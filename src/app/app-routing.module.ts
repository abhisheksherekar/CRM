import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CustomerHomePageComponent } from './customer-home-page/customer-home-page.component';
import { CustomerLoginPageComponent } from "./customer-login-page/customer-login-page.component";
import { CustomerRegisterPageComponent } from "./customer-register-page/customer-register-page.component";
import { HomePageComponent } from "./home-page/home-page.component";
import { InvalidCredentialsComponent } from "./invalid-credentials/invalid-credentials.component";
import { RegistrationSuccessComponent } from "./registration-success/registration-success.component";
import { ProductDetailsComponent } from "./product-details/product-details.component";
import { ServiceProviderListComponent } from "./service-provider-list/service-provider-list.component";
import { CustomerOrderStatusComponent } from "./customer-order-status/customer-order-status.component";
import { AdminLoginComponent } from "./admin-login/admin-login.component";
import { AdminDashboardComponent } from "./admin-dashboard/admin-dashboard.component";
import { AdminRegisterComponent } from "./admin-register/admin-register.component";
import { AdminProductOrderListComponent } from "./admin-product-order-list/admin-product-order-list.component";
import { AdminServiceProviderListComponent } from "./admin-service-provider-list/admin-service-provider-list.component";
import { UpdateServiceProviderComponent } from "./update-service-provider/update-service-provider.component";
import { SpRegisterPageComponent } from "./sp-register-page/sp-register-page.component";
import { SpHomePageComponent } from "./sp-home-page/sp-home-page.component";
import { SpLoginPageComponent } from "./sp-login-page/sp-login-page.component";
import { SpOrderListComponent } from './sp-order-list/sp-order-list.component';

const routes: Routes = [
  { path: 'homepage', component: HomePageComponent },
  { path: 'customer/register', component: CustomerRegisterPageComponent },
  { path: 'customer/login', component: CustomerLoginPageComponent },
  { path: 'customer/home', component: CustomerHomePageComponent },
  { path: 'invalid_credential', component: InvalidCredentialsComponent },
  { path: 'registration_success', component: RegistrationSuccessComponent },
  { path: 'new_request', component: ProductDetailsComponent },
  { path: 'list_of_provider', component: ServiceProviderListComponent },
  { path: 'order_status/:id', component: CustomerOrderStatusComponent },
  { path: 'admin-login', component: AdminLoginComponent },
  { path: 'admin-home', component: AdminDashboardComponent },
  { path: 'admin/register', component: AdminRegisterComponent },
  { path: 'admin-service-provider-list', component: AdminServiceProviderListComponent },
  { path: 'admin-product-order-list', component: AdminProductOrderListComponent },
  { path: 'update-service-provider/:id', component: UpdateServiceProviderComponent },
  { path: 'sp_register', component: SpRegisterPageComponent },
  { path: 'sp_login', component: SpLoginPageComponent },
  { path: 'sp_home', component: SpHomePageComponent },
  { path: 'sp-order-list', component: SpOrderListComponent },
  { path: '', redirectTo: '/homepage', pathMatch: 'full' },///
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
