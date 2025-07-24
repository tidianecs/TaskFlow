import { Component, OnInit } from '@angular/core';
import { KeycloakService } from 'src/app/service/keycloak.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
})
export class NavbarComponent{
  constructor(private keycloakService: KeycloakService){}

  isLoggedIn(): boolean {
    return !!this.keycloakService.keycloak?.authenticated;
  }

  login(): void {
    this.keycloakService.login();
  }

  logout(): void {
    this.keycloakService.logout();
  }
}
