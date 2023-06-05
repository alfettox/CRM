import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

import { SharedModule } from '../shared/shared.module';
import { CustomersComponent } from './customers.component';
import { CustomersListComponent } from './customers-list/customers-list.component';
import { FilterTextboxComponent } from './customers-list/filter-textbox.component';
import { CustomersRoutingModule } from './customers-routing.module';
import { CreateCustomerComponent } from './create-customer/create-customer.component';
import { ModifyCustomerComponent } from './modify-customer/modify-customer.component';
@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    CustomersRoutingModule
  ],
  declarations: [
    CustomersComponent,
    CustomersListComponent,
    FilterTextboxComponent,
    CreateCustomerComponent,
    ModifyCustomerComponent
  ],
  exports: [CustomersComponent],
})
export class CustomersModule {}
