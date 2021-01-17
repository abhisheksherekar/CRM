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
  checkLogin: Boolean;
  constructor(private spservice: ServiceproviderService, private router: Router) { }

  ngOnInit(): void {
    if (sessionStorage.getItem('provider')) {
      this.checkLogin = true;
    }
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

  demo() {
    let xhr = new XMLHttpRequest();
    let url = 'https://api.postalpincode.in/pincode/' + this.provider.spPincode;
    xhr.open('GET', url);
    xhr.send();
    xhr.onload = () => {
      let obj = JSON.parse(xhr.responseText);

      this.provider.spCity = obj[0].PostOffice[0].Block;
      this.provider.spLandmark = obj[0].PostOffice[0].Circle;

    };
  }

}
