import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sp-invoice-page',
  templateUrl: './sp-invoice-page.component.html',
  styleUrls: ['./sp-invoice-page.component.css']
})
export class SpInvoicePageComponent implements OnInit {

  spid: Number;
  spName: String;
  spEmail: String;
  spMobilenumber: String;
  spCity: String;
  date = new Date();
  amt1: String;
  amt2: String;
  grandtotal: String;
  subtotal: String;
  productIssue: String;
  productType: String;
  modelNo: String; issueTwo: String;
  constructor(private router: Router) { }

  ngOnInit(): void {
    if (!sessionStorage.getItem('provider')) {
      this.router.navigate(['sp_login']);
    }
    console.log("---> " + this.date);
    this.spid = JSON.parse(sessionStorage.getItem('provider')).spID;
    this.spName = JSON.parse(sessionStorage.getItem('provider')).spShopname;
    this.spEmail = JSON.parse(sessionStorage.getItem('provider')).spEmail;
    this.spMobilenumber = JSON.parse(sessionStorage.getItem('provider')).spMobilenumber;
    this.spCity = JSON.parse(sessionStorage.getItem('provider')).spCity;
    this.amt1 = sessionStorage.getItem('amt1');
    this.amt2 = sessionStorage.getItem('amt2');
    this.grandtotal = sessionStorage.getItem('grandtotal');
    this.subtotal = sessionStorage.getItem('subtotal');
    //p_details
    this.productIssue = JSON.parse(sessionStorage.getItem('p_details')).productIssue;
    this.productType = JSON.parse(sessionStorage.getItem('p_details')).productType;
    this.modelNo = JSON.parse(sessionStorage.getItem('p_details')).modelNo;
    this.issueTwo = sessionStorage.getItem('issueTwo');
  }

  print() {
    window.print();
  }

}
