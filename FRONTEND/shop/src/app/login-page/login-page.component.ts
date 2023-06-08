import { AuthService } from './../core/auth.service';
import { ICustomer, ISupplier } from './../shared/Interfaces';
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

  constructor(private router: Router, private dataService: DataService, public authservice: AuthService) {}

  isEmailValidSyntax(): boolean {
    const pattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    return pattern.test(this.email);
  }

  async login() {
    if (this.isEmailValidSyntax()) {
      try {
        var customersList = await this.dataService.fetchCustomersBySupplier(this.email).toPromise();
        if (customersList && customersList.length > 0) {
          const customerIds = customersList.map(customer => customer.customerId);
          this.router.navigate(['/customers'], {
            queryParams: { customerId: customerIds.join(',') },
          });
        } else {
          console.log('Customer list is empty');
        }
      } catch (error) {
        console.log('ERROR FETCHING:', error);
      }
    } else {
      console.log('ERROR INVALID EMAIL');
    }
  }
  
}
