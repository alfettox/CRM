import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomersRoutingModule } from './customers/customers-routing.module';
import { LoginPageComponent } from './login-page/login-page.component';
import { CreateCustomerComponent } from './customers/create-customer/create-customer.component';
import { ModifyCustomerComponent } from './customers/modify-customer/modify-customer.component';
import { ItemListComponent } from './item-list/item-list.component';

const routes: Routes = [
  { path: 'customers', loadChildren: () => import('./customers/customers.module').then(m => m.CustomersModule)},    //module
  { path: 'orders', loadChildren: () => import('./orders/orders.module').then(m => m.OrdersModule)},                //module  
  { path: 'products', component: ItemListComponent },
  { path: 'create-customer', component: CreateCustomerComponent }, 
  { path: 'modify-customer', component: ModifyCustomerComponent }, 
  { path: '', pathMatch: 'full', component: LoginPageComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes), CustomersRoutingModule],
  exports: [RouterModule],
})
export class AppRoutingModule {}
