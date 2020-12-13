import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from "../Model/customer";
import { HttpClient } from '@angular/common/http';
import { ProductDetails } from "../Model/product-details";

@Injectable({
  providedIn: 'root'
})
export class CustomerRegistrationService {

  // i: number;
  // customer: Customer = JSON.parse(sessionStorage.getItem('customer'));

  customer: Customer = JSON.parse(sessionStorage.getItem('customer'));
  product_details: any = sessionStorage.getItem('product_details');


  constructor(private http: HttpClient) { }

  public customerLogin(customer: Customer): Observable<any> {
    return this.http.post('http://localhost:8080/loginCustomer', customer);
  }

  public customerRegister(customer: Customer): Observable<any> {
    return this.http.post('http://localhost:8080/addCustomer', customer);
  }

  public insertProductDetails(productdetails: ProductDetails): Observable<any> {
    console.log("---- 1 -----");
    console.log(JSON.parse(sessionStorage.getItem('customer')));
    console.log(JSON.parse(sessionStorage.getItem('customer')).customerId);
    console.log(sessionStorage.getItem('spid'));
    console.log("---2--- CID = " + JSON.parse(sessionStorage.getItem('customer')).customerId + " spid " + sessionStorage.getItem('spid'));
    return this.http.post('http://localhost:8080/addProductDetails?cid=' + JSON.parse(sessionStorage.getItem('customer')).customerId + '&spid=' + sessionStorage.getItem('spid'), productdetails);
  }

  public showProductDetailsById(id: string): Observable<any> {
    console.log("in show data")
    return this.http.get('http://localhost:8080/getProductDetails/' + id);
  }

}

