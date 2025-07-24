import { CanActivateFn, Router, UrlTree } from "@angular/router";
import { KeycloakService } from "../service/keycloak.service";
import { inject } from "@angular/core";

export const authGuard: CanActivateFn = (): boolean | UrlTree => {
    const keycloakService: KeycloakService = inject(KeycloakService);

    if (!keycloakService.isAuthenticated() || keycloakService.keycloak?.isTokenExpired()) {
        keycloakService.login();
        return false;
    }

    return true;
};
