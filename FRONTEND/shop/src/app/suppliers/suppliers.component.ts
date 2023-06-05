import { SuppliersModule } from './suppliers.module';
import { Component } from '@angular/core';
import { ISupplier } from '../shared/Interfaces';

@Component({
  selector: 'app-suppliers',
  templateUrl: './suppliers.component.html',
  styles: [''],
})

export class SuppliersComponent {
  supplier: ISupplier[] = [];
  constructor() {}
}
