import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { TaskService } from '../../service/task.service';
import { Task } from '../../model/task';
import { KeycloakService } from '../../service/keycloak.service';

@Component({
  selector: 'app-tasks',
  templateUrl: './tasks-dashboard.component.html',
})
export class TasksDashboardComponent implements OnInit {
  inProgressTasks: Task[] = [];
  doneTasks: Task[] = [];
  newTaskContent: string = '';
  newTaskDueDate: string = ''; 

  constructor(
    private route: ActivatedRoute,
    private taskService: TaskService,
    private keycloakService: KeycloakService
  ) {}

  ngOnInit(): void {
    const projectId = this.route.snapshot.paramMap.get('projectId');
    if (projectId) {
      this.taskService.getTasksByProject(+projectId).subscribe({
        next: tasks => {
          this.inProgressTasks = tasks.filter(task => task.status === 'IN_GOING');
          this.doneTasks = tasks.filter(task => task.status === 'DONE');
        },
        error: err => console.error(err)
      });
    }
    this.loadTasks();
  }

  loadTasks(): void {
    const userId = this.keycloakService.getUserId();
    if (!userId) {
      console.error('User ID not found.');
      return;
    }

    this.taskService.getUserTasks(userId).subscribe({
      next: (tasks) => {
        const formattedTasks = tasks.map(task => ({
          ...task,
          createdAt: task.createdAt ? new Date(task.createdAt) : new Date(),
          dueDate: task.dueDate ? new Date(task.dueDate) : null
        }));

        this.inProgressTasks = formattedTasks.filter(task => task.status === 'IN_GOING');
        this.doneTasks = formattedTasks.filter(task => task.status === 'DONE');
      },
      error: (err) => console.error(err)
    });
  }


  addTask() {
    const projectId = this.route.snapshot.paramMap.get('projectId');

    if (projectId && this.newTaskContent) {
      const newTask = {
        content: this.newTaskContent,
        dueDate: new Date(this.newTaskDueDate).toISOString(), 
        status: 'IN_GOING',
        projectId: +projectId
      };

      this.taskService.addTask(newTask).subscribe({
        next: (createdTask: Task) => {
          this.inProgressTasks.unshift(createdTask);
          this.newTaskContent = '';
          this.newTaskDueDate = '';
        },
        error: (err) => console.error(err)
      });
    }
  }

  markTaskAsDone(taskId: number) {
    console.log("Marking as done, received taskId:", taskId);
    if (!taskId) {
      console.error("taskId is undefined, cannot mark as done.");
      return;
    }
    this.taskService.markTaskAsDone(taskId).subscribe({
      next: () => {
        const task = this.inProgressTasks.find(task => task.taskId === taskId);
        if (task) {
          task.status = 'DONE';
          this.inProgressTasks = this.inProgressTasks.filter(task => task.taskId !== taskId);
          this.doneTasks.unshift(task);
        }
      },
      error: err => console.error(err)
    });
  }

  delTask(taskId: number) {
    this.taskService.deleteTask(taskId).subscribe({
      next: () => {
        this.inProgressTasks = this.inProgressTasks.filter(task => task.taskId !== taskId);
        this.doneTasks = this.doneTasks.filter(task => task.taskId !== taskId);
      },
      error: err => console.error(err)
    });
  }
}
