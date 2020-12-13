import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceProvider } from '../Model/service-provider';
import { ServiceproviderService } from '../service/serviceprovider.service';

@Component({
  selector: 'app-sp-login-page',
  templateUrl: './sp-login-page.component.html',
  styleUrls: ['./sp-login-page.component.css']
})
export class SpLoginPageComponent implements OnInit {

  provider: ServiceProvider = new ServiceProvider();
  constructor(private spserv: ServiceproviderService, private router: Router) { }

  ngOnInit(): void {
  }

  onSubmit() {
    this.spserv.LoginServiceProvider(this.provider).subscribe(
      data => {
        console.log("SP login");
        console.log(data);
        sessionStorage.setItem('provider', JSON.stringify(data));
        console.log("------------------------------->");
        //JSON.parse(sessionStorage.getItem('provider')).spID
        // console.log( sessionStorage.getItem('provider').spID);
        console.log(JSON.parse(sessionStorage.getItem('provider')).spID);
        this.router.navigate(['sp_home']);
      },
      error => {
        this.router.navigate(['invalid_credential']);
      }
    );
  }

}
