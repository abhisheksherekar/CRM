import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Admin } from "../Model/admin";
import { AdminservService } from "../service/adminserv.service";
@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {

  admin: Admin = new Admin();
  errMsg: Boolean;
  constructor(private adminservice: AdminservService, private router: Router) { }

  ngOnInit(): void {
  }

  adminLogin() {
    this.adminservice.adminLogin(this.admin).subscribe(
      data => {
        console.log("Admin login")
        console.log(data);
        sessionStorage.setItem('admin', data);
        this.router.navigate(['admin-home']);
      },
      error => {
        this.errMsg = true;
        console.log("ERRRRRRRR---")
      });
  }

}
