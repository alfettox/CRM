import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ICustomer } from '../../shared/Interfaces';

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})
export class CreateCustomerComponent {
  customer: ICustomer = {
    id: 0,
    fName: '',
    lName: '',
    phoneNum: '',
    shippingAddress: '',
    email: ''
  };

  constructor(private http: HttpClient) {}

  createCustomer() {
    this.http.post('http://localhost:8080/customers/', this.customer)
      .subscribe(
        () => {
          console.log('Customer created successfully');
        },
        (error) => {
          console.log('Error creating customer:', error);
        }
      );
  }
}
