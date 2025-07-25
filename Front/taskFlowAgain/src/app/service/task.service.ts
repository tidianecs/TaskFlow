import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Task } from '../model/task';
import { KeycloakService } from './keycloak.service';

@Injectable({
  providedIn: 'root'
})
export class TaskService {
  private apiUrl = 'http://localhost:8081/task';

  constructor(private http: HttpClient, private keycloakService: KeycloakService) {}

  getTasksByProject(projectId: number): Observable<Task[]> {
    const headers = {
      'Authorization': `Bearer ${this.keycloakService.userProfile?.token}`
    };
    return this.http.get<Task[]>(`${this.apiUrl}/project/${projectId}`, { headers });
  }

  addTask(task: any): Observable<Task> {
    const headers = {
      'Authorization': `Bearer ${this.keycloakService.userProfile?.token}`
    };
    return this.http.post<Task>(`${this.apiUrl}`, task, { headers });
  }

  getUserTasks(userId: string): Observable<Task[]> {
    const headers = {
      'Authorization': `Bearer ${this.keycloakService.userProfile?.token}`
    };
    return this.http.get<Task[]>(`${this.apiUrl}/user/${userId}`, { headers });
  }

  markTaskAsDone(taskId: number): Observable<string> {
    const headers = {
        'Authorization': `Bearer ${this.keycloakService.userProfile?.token}`
    };
    return this.http.put(`${this.apiUrl}/${taskId}`, null, { headers, responseType: 'text' });
  }

  deleteTask(taskId: number) {
      const headers = {
          'Authorization': `Bearer ${this.keycloakService.userProfile?.token}`
      };
      return this.http.delete(`${this.apiUrl}/${taskId}`, { headers });
  }

}

