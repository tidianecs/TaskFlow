import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProjectsDashboardComponent } from './layouts/projects-dashboard/projects-dashboard.component';
import { authGuard } from './core/auth.guard';
import { HomepageComponent } from './layouts/homepage/homepage.component';
import { TasksDashboardComponent } from './layouts/tasks-dashboard/tasks-dashboard.component';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomepageComponent },
  { path: 'projects-dashboard', component: ProjectsDashboardComponent, canActivate: [authGuard] },
  { path: 'tasks/:projectId', component: TasksDashboardComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
