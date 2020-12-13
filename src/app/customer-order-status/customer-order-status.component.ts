import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CustomerRegistrationService } from '../service/customer-registration.service';

@Component({
  selector: 'app-customer-order-status',
  templateUrl: './customer-order-status.component.html',
  styleUrls: ['./customer-order-status.component.css']
})
export class CustomerOrderStatusComponent implements OnInit {

  productList: any;
  constructor(private route: ActivatedRoute, private customerservice: CustomerRegistrationService) { }

  ngOnInit(): void {
    const id = this.route.snapshot.params['id'];
    console.log("ID => " + id);
    this.customerservice.showProductDetailsById(id).subscribe(

      data => {
        console.log(data);
        this.productList = data;
      },
      error => { console.log("ERR") }
    );
    console.log("data---->");
  }

}
