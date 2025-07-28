import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Task } from '../model/task';
import { KeycloakService } from './keycloak.service';

@Injectable({
  providedIn: 'root'
})
export class NotificationService{
  private apiUrl = 'http://localhost:8081/task/due-today'


  constructor(private http: HttpClient, private keycloakService: KeycloakService){}

  getDueTodayTasks(): Observable<Task[]>{
    const token = this.keycloakService.getToken();
    const headers = new HttpHeaders({
      Authorization: `Bearer ${token}`
    });
    return this.http.get<Task[]>(this.apiUrl, { headers });
  }
}
