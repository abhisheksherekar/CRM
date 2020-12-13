import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceProvider } from "../Model/service-provider";
import { ServiceproviderService } from "../service/serviceprovider.service";
@Component({
  selector: 'app-sp-register-page',
  templateUrl: './sp-register-page.component.html',
  styleUrls: ['./sp-register-page.component.css']
})
export class SpRegisterPageComponent implements OnInit {

  provider: ServiceProvider = new ServiceProvider();

  constructor(private spservice: ServiceproviderService, private router: Router) { }

  ngOnInit(): void {
  }

  onSubmit() {
    this.spservice.addServiceProvider(this.provider).subscribe(
      data => {
        console.log("sp added");
        this.router.navigate(['sp_login']);
      },
      error => { console.log("sp ERROR"); }
    );
  }

}
