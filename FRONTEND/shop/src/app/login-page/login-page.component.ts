import { ISupplier } from './../shared/Interfaces';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { DataService } from '../core/data.service'; // Import the DataService

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css'],
})
export class LoginPageComponent {
  email: string = '';

  constructor(private router: Router, private dataService: DataService) {}

  isEmailValidSyntax(): boolean {
    const pattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    return pattern.test(this.email);
  }

  async login() {
    if (this.isEmailValidSyntax()) {
      try {
        const suppliersList = await this.dataService.fetchSuppliers();
  
        suppliersList.forEach((supplier: ISupplier[]) => {
          for (let i = 0; i < supplier.length; i++) {
            supplier[i].supEmail = supplier[i].supEmail.toLowerCase();
            if (supplier[i].supEmail === this.email.toLowerCase()) {
              this.router.navigate(['/customers'], {
                queryParams: { supplierId: supplier[i].supplierId },
              });
              break;
            }
          }
        });
      } catch (error) {
        console.log('ERROR FETCHING:', error);
      }
    } else {
      console.log('ERROR INVALID EMAIL');
    }
  }
  
}
