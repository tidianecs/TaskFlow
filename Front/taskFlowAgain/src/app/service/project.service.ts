import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Project } from '../model/project';
import { KeycloakService } from './keycloak.service';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {
  private apiUrl = 'http://localhost:8081/project';

  constructor(private http: HttpClient, private keycloakService: KeycloakService) { }

  getUserProjects(userId: string): Observable<Project[]> {
    const headers = {
      'Authorization': `Bearer ${this.keycloakService.userProfile?.token}`
    };
    return this.http.get<Project[]>(`${this.apiUrl}/my-projects`, { headers });
  }

  addProject(project: any): Observable<Project> {
    const headers = {
      'Authorization': `Bearer ${this.keycloakService.userProfile?.token}`
    };
    return this.http.post<Project>(`${this.apiUrl}`, project, { headers });
  }

  deleteProject(projectId: number) {
    const headers = {
      'Authorization': `Bearer ${this.keycloakService.userProfile?.token}`
    };
    return this.http.delete(`${this.apiUrl}/${projectId}`, { headers });
  }


}
