import { NgModule }      from '@angular/core';
import { CommonModule } from '@angular/common';

import { CustomersComponent }  from './customers.component';
import { FilterTextboxComponent } from './customers-list/filter-textboxcomponent';
import { CustomersListComponent } from './customers-list/customers-list.component';
import { FormsModule } from '@angular/forms';
import { SharedModule } from '../shared/shared.module';

@NgModule({
  imports:      [ CommonModule, SharedModule, FormsModule],
  declarations: [ CustomersComponent, CustomersListComponent, FilterTextboxComponent ],
  exports: [ CustomersComponent ]
})
export class CustomersModule { }