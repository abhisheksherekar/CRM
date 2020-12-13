import { error } from '@angular/compiler/src/util';
import { Component, OnInit } from '@angular/core';
import { NgForm } from "@angular/forms";
import { Router } from '@angular/router';
import { Customer } from '../Model/customer';
import { CustomerRegistrationService } from '../service/customer-registration.service';
@Component({
  selector: 'app-customer-login-page',
  templateUrl: './customer-login-page.component.html',
  styleUrls: ['./customer-login-page.component.css']
})

export class CustomerLoginPageComponent implements OnInit {

  customer = new Customer();
  msg = '';
  constructor(private customerservice: CustomerRegistrationService, private router: Router) {
  }

  ngOnInit(): void {
  }

  customerLogin() {
    this.customerservice.customerLogin(this.customer).subscribe(
      data => {
        console.log("login sucess...!!! ");
        console.log(" customer :: ");
        sessionStorage.setItem('customer', JSON.stringify(data));
        console.log(sessionStorage.getItem('customer'));
        //sessionStorage.setItem()
        this.router.navigate(['customer/home']);
      },
      error => {
        this.router.navigate(['invalid_credential']); //navigate the route
      }
    )
  }

}

