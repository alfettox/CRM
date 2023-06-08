import { SuppliersModule } from './suppliers.module';
import { Component } from '@angular/core';
import { ISupplier } from '../shared/Interfaces';
import { Router } from '@angular/router';
import { AuthService } from '../core/auth.service';

@Component({
  selector: 'app-suppliers',
  templateUrl: './suppliers.component.html',
  styles: [''],
})

export class SuppliersComponent {
  supplier: ISupplier[] = [];
  constructor(private router: Router, private authService: AuthService) {}
}
