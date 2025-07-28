import { Component, OnInit } from '@angular/core';
import { NotificationService } from '../../service/notification.service';
import { Task } from '../../model/task';
import { Router } from '@angular/router';

@Component({
  selector: 'app-notifications',
  templateUrl: './notifications.component.html',
  styleUrls: ['./notifications.component.css']
})
export class NotificationsComponent implements OnInit {
  notifications: Task[] = [];
  notifView: boolean = false; 

  constructor(private notificationService: NotificationService, private router: Router) {}

  ngOnInit(): void {
    this.loadNotifications();

    // reload every 30s
    setInterval(() => {
      this.loadNotifications();
    }, 30000);

  }

  loadNotifications(): void {
    this.notificationService.getDueTodayTasks().subscribe({
      next: tasks => {this.notifications = tasks, console.log('Tâches reçues :', this.notifications)},
      error: err => console.error('Erreur notifications :', err)

    });
  }

  goToProject(projectId: number): void {
    this.router.navigate(['tasks/', projectId]);
  }

  showNotifactionsBubble(): void{
    this.notifView = true;
  }

  hideNotificationsBubble(): void{
    this.notifView = false;
  }
}
