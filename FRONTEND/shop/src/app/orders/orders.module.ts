import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { SharedModule } from '../shared/shared.module';
import { OrdersComponent } from './orders.component';
import { OrdersRoutingModule } from './orders-routing.module';

@NgModule({
  imports: [SharedModule, CommonModule, FormsModule, OrdersRoutingModule],
  declarations: [OrdersComponent],
  
})
export class OrdersModule {
}
