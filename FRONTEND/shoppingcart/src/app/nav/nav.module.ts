import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { NavRoutingModule } from './nav-routing.module';
import { NavComponent } from './nav.component';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    NavRoutingModule
  ],
  exports: [
    NavModule
  ]
})
export class NavModule { }
