import { NgModule } from '@angular/core';
import { Router, RouterModule, Routes } from '@angular/router';
import { CustomersRoutingModule } from './customers/customers-routing.module';
import { LoginPageComponent } from './login-page/login-page.component';
import { CreateCustomerComponent } from './customers/create-customer/create-customer.component';
import { ModifyCustomerComponent } from './customers/modify-customer/modify-customer.component';
import { ItemListComponent } from './item-list/item-list.component';
import { AboutUsComponent } from './about/about-us/about-us.component';
import { ContactComponent } from './contact/contact/contact.component';
import { PhoneNumberFormatPipe } from './shared/phone.pipe';

const routes: Routes = [
  { path: 'customers', loadChildren: () => import('./customers/customers.module').then(m => m.CustomersModule)},    //module
  { path: 'orders', loadChildren: () => import('./orders/orders.module').then(m => m.OrdersModule)},                //module  
  { path: 'products', component: ItemListComponent },
  { path: 'create-customer', component: CreateCustomerComponent }, 
  { path: 'modify-customer', component: ModifyCustomerComponent }, 
  { path: '', pathMatch: 'full', component: LoginPageComponent },
  { path: 'login', component: LoginPageComponent },
  { path: 'about', component: AboutUsComponent },
  { path: 'contact', component: ContactComponent },
  { path: 'orders/:customerId',  loadChildren: () => import('./orders/orders.module').then(m => m.OrdersModule)},               


];


@NgModule({
  imports: [RouterModule.forRoot(routes), CustomersRoutingModule],
  exports: [RouterModule],
  providers: [PhoneNumberFormatPipe],
})
export class AppRoutingModule {
  isLoginPage: boolean = false;

  constructor(private router: Router) {}

  onRouterActivate(event: any) {
    this.isLoginPage = event.constructor.name === 'LoginPageComponent';
  }


}
