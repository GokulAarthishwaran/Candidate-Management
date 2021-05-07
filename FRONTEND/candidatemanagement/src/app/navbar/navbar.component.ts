import { Component, OnInit } from '@angular/core';
import {SecurityService} from "../security.service";
import {Router} from "@angular/router";
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private http: HttpClient, private securityService: SecurityService, private router: Router) {}

  ngOnInit(): void {
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
