import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { TaskService } from '../../service/task.service';
import { Task } from '../../model/task';

@Component({
  selector: 'app-tasks',
  templateUrl: './tasks-dashboard.component.html'
})
export class TasksDashboardComponent implements OnInit {
  tasks: Task[] = [];

  constructor(
    private route: ActivatedRoute,
    private taskService: TaskService
  ) {}

  ngOnInit(): void {
    const projectId = this.route.snapshot.paramMap.get('projectId');
    if (projectId) {
      //we convert thr projectId(String in the URL) => number
      this.taskService.getTasksByProject(+projectId).subscribe({
        next: tasks => this.tasks = tasks,
        error: err => console.error(err)
      });
    }
  }
}
