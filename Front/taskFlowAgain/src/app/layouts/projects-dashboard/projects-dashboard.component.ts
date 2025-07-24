import { Component, OnInit } from '@angular/core';
import { ProjectService } from '../../service/project.service';
import { Project } from 'src/app/model/project';
import { KeycloakService } from '../../service/keycloak.service';

@Component({
  selector: 'app-projects-dashboard',
  templateUrl: './projects-dashboard.component.html'
})
export class ProjectsDashboardComponent{
  projects: Project[] = [];
  newProject: Project = { projectName: '', projectDesc: '' };

  constructor(
    private projectService: ProjectService,
    private keycloakService: KeycloakService
  ) {}
  //implements onInit
  /*ngOnInit(): void {
    this.loadProjects();
  }

    loadProjects(): void {
    const userId = this.keycloakService.getUserId();
    this.projectService.getUserProjects(userId).subscribe({
      next: (projects) => this.projects = projects,
      error: (err) => console.error(err)
    });
  }*/

  addProject(): void {
    this.projectService.addProject(this.newProject).subscribe({
      next: () => {
        this.newProject = { projectName: '', projectDesc: '' };
        //this.loadProjects();
      },
      error: (err) => console.error(err)
    });
  }
}
