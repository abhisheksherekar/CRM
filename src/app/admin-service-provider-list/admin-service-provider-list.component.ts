import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AdminservService } from '../service/adminserv.service';
import { ServiceproviderService } from '../service/serviceprovider.service';

@Component({
  selector: 'app-admin-service-provider-list',
  templateUrl: './admin-service-provider-list.component.html',
  styleUrls: ['./admin-service-provider-list.component.css']
})
export class AdminServiceProviderListComponent implements OnInit {

  provider: any;
  constructor(private adminservice: AdminservService, private serviceproviderservice: ServiceproviderService, private router: Router) { }

  ngOnInit(): void {
    this.serviceproviderservice.getAllProvider().subscribe(data => {
      console.log("SP DISPLAYED");
      this.provider = data;
    });
  }

  onUpdate(spid: number) {
    this.router.navigate(['update-service-provider', spid]);
  }

  onDelete(spid: number) {

  }
}
