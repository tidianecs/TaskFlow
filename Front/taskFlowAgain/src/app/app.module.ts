import { APP_INITIALIZER, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomepageComponent } from './layouts/homepage/homepage.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { ProjectsDashboardComponent } from './layouts/projects-dashboard/projects-dashboard.component';
import { KeycloakService } from './service/keycloak.service';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { TasksDashboardComponent } from './layouts/tasks-dashboard/tasks-dashboard.component';
import { CommonModule, DatePipe } from '@angular/common';
import { NotificationsComponent } from './layouts/notifications/notifications.component';

export function kcFactory(kcService: KeycloakService){
  return () => kcService.init();
}

@NgModule({
  declarations: [
    AppComponent,
    HomepageComponent,
    NavbarComponent,
    ProjectsDashboardComponent,
    TasksDashboardComponent,
    NotificationsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    CommonModule
  ],
  providers: [
    {
      provide: APP_INITIALIZER,
      deps: [KeycloakService],
      useFactory: kcFactory,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
