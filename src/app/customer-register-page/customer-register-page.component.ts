import { error } from '@angular/compiler/src/util';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from '../Model/customer';
import { CustomerRegistrationService } from '../service/customer-registration.service';

@Component({
  selector: 'app-customer-register-page',
  templateUrl: './customer-register-page.component.html',
  styleUrls: ['./customer-register-page.component.css']
})
export class CustomerRegisterPageComponent implements OnInit {

  customer = new Customer();
  errMsg = '';
  constructor(private customerservice: CustomerRegistrationService, private router: Router) { }

  ngOnInit(): void {
  }

  customerRegister() {
    this.customerservice.customerRegister(this.customer).subscribe(
      data => {
        console.log("Registration success..");
        this.router.navigate(['registration_success']);
      },
      error => {
        console.log("Error..!!");
        this.errMsg = "Email-Id already exist..!!!";
      }
    )
  }

}
