import { Component, OnInit } from '@angular/core';
import { CustomerRegistrationService } from '../service/customer-registration.service';
import { ServiceproviderService } from "../service/serviceprovider.service";
import { ProductDetails } from "../Model/product-details";
import { Router } from '@angular/router';

@Component({
  selector: 'app-service-provider-list',
  templateUrl: './service-provider-list.component.html',
  styleUrls: ['./service-provider-list.component.css']
})

export class ServiceProviderListComponent implements OnInit {
  constructor(private serviceproviderservice: ServiceproviderService, private customerservice: CustomerRegistrationService,
    private router: Router) { }

  providerlist: any;
  Productdetails: ProductDetails = new ProductDetails();
  // product_details: any = localStorage.getItem('product_details');
  //Productdetails: ProductDetails = JSON.parse(localStorage.getItem('product_details'));
  //idd: number;
  ngOnInit(): void {
    this.serviceproviderservice.getAllProvider().subscribe(data => {
      this.providerlist = data;
      console.log("list of provider");
      console.log(data);
    }, error => {
      console.log(" ERROR ....fhgjkl ");
    });
    console.log("===================>>>>>>>");
    console.log(history.state);
    console.log("////////");
    //console.log(this.router.getCurrentNavigation().extras.state);
  }

  onSelect(spId: any) {
    sessionStorage.setItem('spid', spId);
    console.log("***** " + spId);
    console.log(sessionStorage.getItem('spid'));
    //console.log(sessionStorage.getItem('product_details'));//null 
    this.customerservice.insertProductDetails(history.state).subscribe(data => {
      console.log(data);
      sessionStorage.setItem('product_details', JSON.stringify(data));
      console.log(sessionStorage.getItem('product_details'));
      console.log("into onselect");
      this.router.navigate(['order_status', JSON.parse(sessionStorage.getItem('product_details')).productId]);
    });

    // this.Productdetails = JSON.parse(sessionStorage.getItem('product_details'));
    // console.log(JSON.parse(sessionStorage.getItem('product_details')));
    // console.log("***** success 1234 --> " + JSON.parse(sessionStorage.getItem('product_details')).productId);
    // this.router.navigate(['order_status', JSON.parse(sessionStorage.getItem('product_details')).productId]);
  }
}
