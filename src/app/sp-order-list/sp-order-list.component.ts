import { Component, OnInit } from '@angular/core';
import { ServiceproviderService } from "../service/serviceprovider.service";
@Component({
  selector: 'app-sp-order-list',
  templateUrl: './sp-order-list.component.html',
  styleUrls: ['./sp-order-list.component.css']
})
export class SpOrderListComponent implements OnInit {

  constructor(private spservice: ServiceproviderService) { }

  ngOnInit(): void {
    //this.spservice.showAllorderById1()
  }

}
