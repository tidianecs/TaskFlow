import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpEvent, HttpHandler, HttpRequest, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { KeycloakService } from '../service/keycloak.service';

@Injectable()
export class TokenInterceptor implements HttpInterceptor {

    constructor(private keycloakService: KeycloakService){}

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        const token = this.keycloakService.keycloak.token;
        if(token){
            const authReq: HttpRequest<any> = req.clone({
                headers: new HttpHeaders({
                    Authorization: 'Bearer ' + token
                })
            })
            return next.handle(authReq);
        }
        return next.handle(req);
    }


}