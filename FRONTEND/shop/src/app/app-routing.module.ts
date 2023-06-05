import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomersRoutingModule } from './customers/customers-routing.module';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: '/customers' },
  { path: 'customers', loadChildren: () => import('./customers/customers.module').then(m => m.CustomersModule)},
  { path: 'orders', loadChildren: () => import('./orders/orders.module').then(m => m.OrdersModule)},
  // { path: '**', pathMatch: 'full', redirectTo: '/customers' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes), CustomersRoutingModule],
  exports: [RouterModule],
})
export class AppRoutingModule {}
