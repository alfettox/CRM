import { Component, OnInit, ViewChild } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ToastrService } from 'ngx-toastr';
import { NgForm } from '@angular/forms';
import { ICustomer } from '../../shared/Interfaces';

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})
export class CreateCustomerComponent implements OnInit {
  @ViewChild('customerForm', { static: true }) customerForm!: NgForm;
  customer: ICustomer = {
    customerId: 0,
    fName: '',
    lName: '',
    phoneNum: '',
    shippingAddress: '',
    email: ''
  };

  constructor(private http: HttpClient, private toastr: ToastrService) {}

  ngOnInit(): void {
  }

  createCustomer() {
    this.http
      .post('http://localhost:8080/customers/add', this.customer)
      .subscribe(
        () => {
          this.toastr.success('Customer created successfully', 'Success');
          console.log('Customer created:', this.customer);
        },
        (error) => {
          this.toastr.error('Error creating customer', 'Error');
          console.error('Error creating customer:', error);
        }
      );
  }

  isInvalidControl(controlName: string): boolean {
    const control = this.customerForm?.controls[controlName];
    return !!control && (control.invalid && (control.dirty || control.touched));
  }

  hasError(controlName: string, errorName: string): boolean {
    const control = this.customerForm?.controls[controlName];
    return control?.hasError(errorName);
  }
}

