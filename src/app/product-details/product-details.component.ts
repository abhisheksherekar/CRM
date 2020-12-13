import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProductDetails } from "../Model/product-details";
import { CustomerRegistrationService } from '../service/customer-registration.service';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})

export class ProductDetailsComponent implements OnInit {


  constructor(private customerservice: CustomerRegistrationService, private router: Router) { }

  productdetail: ProductDetails = new ProductDetails();

  ngOnInit(): void {
  }

  onSubmit() {
    // this.customerservice.insertProductDetails(this.productdetail).subscribe(
    //   data => {
    //     console.log("product added");
    //     localStorage.setItem('product_details', JSON.stringify(data));
    //     //console.log(localStorage.getItem('customer'));
    //     this.router.navigate(['list_of_provider']);
    //   },
    //   error => { console.log("product ERRROR") }
    // );
    console.log("NAVIGATE ROUTE");
    console.log(this.productdetail);
    this.router.navigateByUrl('list_of_provider', { state: this.productdetail });
  }

}
