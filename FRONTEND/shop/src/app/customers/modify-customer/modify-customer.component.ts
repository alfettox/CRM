import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ICustomer } from '../../shared/Interfaces';

@Component({
  selector: 'app-modify-customer',
  templateUrl: './modify-customer.component.html',
  styleUrls: ['./modify-customer.component.css']
})

export class ModifyCustomerComponent {
  customer: ICustomer = {
    id: 0,
    fName: '',
    lName: '',
    phoneNum: '',
    shippingAddress: '',
    email: ''
  };

  constructor(private http: HttpClient) {}

  modifyCustomer() {
    this.http.put('http://localhost:8080/customers/' + this.customer.id, this.customer)      .subscribe(
        () => {
          console.log('Customer modified successfully');
        },
        (error) => {
          console.log('Error creating customer:', error);
        }
      );
  }
}
