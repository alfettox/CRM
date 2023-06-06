// SharedModule is meant to contains pipes and directive that can be used across the application.

import { NgModule } from '@angular/core';

import { CapitalizePipe } from './capitalize.pipe';

@NgModule({
    declarations: [ CapitalizePipe ],
    exports: [ CapitalizePipe ]
})
export class SharedModule { }