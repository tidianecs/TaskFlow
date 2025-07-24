import { Injectable } from '@angular/core';
import Keycloak, { KeycloakInstance } from 'keycloak-js';
import { UserProfile } from '../model/user-profile';

@Injectable({
  providedIn: 'root'
})
export class KeycloakService {
  private kc: Keycloak | undefined;
  private profile: UserProfile | undefined;

  get keycloak(){
    if(!this.kc){
      this.kc = new Keycloak({
        url: 'http://localhost:8080',
        realm: 'TaskFlowRealm',
        clientId: 'taskFlow-client'
      })
    }
    return this.kc;
  }

  get userProfile(): UserProfile | undefined{
    return this.profile;
  }

  constructor() { }

  async init(){
    console.log('Auth User');
    const authenticated = await this.keycloak?.init({
      onLoad: 'login-required',
      checkLoginIframe: false,
    })

    if(authenticated){
      console.log("User AUthenticated...");
      this.profile = (await this.keycloak?.loadUserProfile()) as UserProfile;
      this.profile.token = this.keycloak?.token;

      //console.log("Token récupéré :", this.keycloak.token);
    }
  }

  isAuthenticated(): boolean {
    return !!this.kc?.authenticated;
  }


  login(){
    return this.keycloak?.login();
  }

  logout(){
    return this.keycloak?.logout({redirectUri: 'http://localhost:4200'})
  }
}
