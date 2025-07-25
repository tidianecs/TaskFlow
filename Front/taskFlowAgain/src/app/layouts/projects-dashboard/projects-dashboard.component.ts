import { Component, OnInit } from '@angular/core';
import { ProjectService } from '../../service/project.service';
import { Project } from 'src/app/model/project';
import { KeycloakService } from '../../service/keycloak.service';

@Component({
  selector: 'app-projects-dashboard',
  templateUrl: './projects-dashboard.component.html'
})
export class ProjectsDashboardComponent implements OnInit{
  projects: Project[] = [];
  newProject = { projectName: '', projectDesc: '' };



  constructor(
    private projectService: ProjectService,
    private keycloakService: KeycloakService
  ) {}

  ngOnInit(): void {
    this.loadProjects();
  }

    loadProjects(): void {
      const userId = this.keycloakService.getUserId();
      if (!userId) {
          console.error('User ID not found.');
          return;
      }
      this.projectService.getUserProjects(userId).subscribe({
        next: (projects) => this.projects = projects,
        error: (err) => console.error(err)
      });
  }


  addProject(): void {
    const userId = this.keycloakService.getUserId();
    if (!userId) {
      console.error('User ID not found.');
      return;
    }

    const projectToSave = {
      projectName: this.newProject.projectName,
      projectDesc: this.newProject.projectDesc
    };

    //console.log("Project avant envoi :", projectToSave);

    this.projectService.addProject(projectToSave).subscribe({
      next: () => {
        this.newProject = { projectName: '', projectDesc: '' };
        this.loadProjects();
      },
      error: (err) => console.error(err)
    });
  }
  deleteProject(projectId: number) {
    this.projectService.deleteProject(projectId).subscribe({
      next: () => {
        this.projects = this.projects.filter(p => p.projectId !== projectId);
      },
      error: (err) => console.error(err)
    });
  }

}
