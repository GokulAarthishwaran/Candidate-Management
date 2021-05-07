import { Component, OnInit, NgZone } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {SecurityService} from "../security.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})

export class HomeComponent implements OnInit {

  name;

  constructor(private http: HttpClient, private securityService: SecurityService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.getUserInfo().subscribe(data => {this.name = data.name;this.securityService.updateName(this.name);});
  }

  getUserInfo(): Observable<any> {
    return this.http.get(environment.baseUrl + '/v1/home');
  }

  logout()
  {
    this.securityService.logout() .subscribe(() => {
      this.securityService.removeToken();
      this.securityService.removeName();
      this.router.navigate(['/login']);
    });
  }




}
