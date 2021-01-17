import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {

  x: any;
  checkLogin: Boolean;
  constructor(private router: Router) { }

  ngOnInit(): void {
    if (!sessionStorage.getItem('admin')) {

      this.router.navigate(['admin-login']);
    }

    if (sessionStorage.getItem('admin')) {
      this.checkLogin = true;
    }

    this.x = JSON.parse(sessionStorage.getItem('admin')).adminName;
  }

  logout() {
    sessionStorage.removeItem('admin');
    this.router.navigate(['admin-login']);
  }

}
