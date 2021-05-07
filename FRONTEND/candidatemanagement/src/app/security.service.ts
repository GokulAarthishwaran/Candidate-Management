import { Injectable } from '@angular/core';
import {environment} from "../environments/environment";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})

export class SecurityService {

  private authorizeEndpoint = '/oauth2/authorization/google'
  private tokenEndpoint = '/login/oauth2/code/google';
  private baseUrl = environment.baseUrl;
  private tokenKey = 'token';

  constructor(private http: HttpClient) {
  }

  login() {
    window.open(this.baseUrl + this.authorizeEndpoint, '_self');
  }

  updateToken(token) {
    localStorage.setItem(this.tokenKey, token);
  }
  
  updateName(token : string) {
    localStorage.setItem("name", token);
  }


  fetchToken(code, state): Observable<any> {
    return this.http.get(this.baseUrl + this.tokenEndpoint + '?code=' + code + '&state=' + state);
  }

  getToken() {
    return localStorage.getItem(this.tokenKey);
  }

  getName()
  {
    return localStorage.getItem("name");
  }

  isLoggedIn(): boolean {
    const token = this.getToken();
    return token != null;
  }

  removeToken() {
    localStorage.removeItem(this.tokenKey);
  }

  removeName() {
    localStorage.removeItem("name");
  }

  logout(): Observable<any> {
    return this.http.post(this.baseUrl + '/logout', this.getToken());
  }

}
