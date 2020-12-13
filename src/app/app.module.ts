import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
//import { DataTablesModule } from 'angular-datatables';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { HomePageComponent } from './home-page/home-page.component';
import { CustomerRegisterPageComponent } from './customer-register-page/customer-register-page.component';
import { CustomerLoginPageComponent } from './customer-login-page/customer-login-page.component';
import { CustomerHomePageComponent } from './customer-home-page/customer-home-page.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { RegistrationSuccessComponent } from './registration-success/registration-success.component';
import { InvalidCredentialsComponent } from './invalid-credentials/invalid-credentials.component';
import { ProductDetailsComponent } from './product-details/product-details.component';
import { ServiceProviderListComponent } from './service-provider-list/service-provider-list.component';
import { CustomerOrderStatusComponent } from './customer-order-status/customer-order-status.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { AdminRegisterComponent } from './admin-register/admin-register.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { AdminProductOrderListComponent } from './admin-product-order-list/admin-product-order-list.component';
import { AdminServiceProviderListComponent } from './admin-service-provider-list/admin-service-provider-list.component';
import { UpdateServiceProviderComponent } from './update-service-provider/update-service-provider.component';
import { SpHomePageComponent } from './sp-home-page/sp-home-page.component';
import { SpLoginPageComponent } from './sp-login-page/sp-login-page.component';
import { SpRegisterPageComponent } from './sp-register-page/sp-register-page.component';
import { SpOrderListComponent } from './sp-order-list/sp-order-list.component';

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    CustomerRegisterPageComponent,
    CustomerLoginPageComponent,
    CustomerHomePageComponent,
    NavBarComponent,
    RegistrationSuccessComponent,
    InvalidCredentialsComponent,
    ProductDetailsComponent,
    ServiceProviderListComponent,
    CustomerOrderStatusComponent,
    AdminLoginComponent,
    AdminRegisterComponent,
    AdminDashboardComponent,
    AdminProductOrderListComponent,
    AdminServiceProviderListComponent,
    UpdateServiceProviderComponent,
    SpHomePageComponent,
    SpLoginPageComponent,
    SpRegisterPageComponent,
    SpOrderListComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    //DataTablesModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
