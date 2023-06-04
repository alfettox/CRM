import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent {
  paymentForm: FormGroup;

  constructor(private formBuilder: FormBuilder) {
    this.paymentForm = this.formBuilder.group({
      cardNumber: ['', [Validators.required]],
      expiryDate: ['', [Validators.required]],
      cvv: ['', [Validators.required]]
    });
  }

  submitPayment() {
    if (this.paymentForm.invalid) {
      return;
    }

  }
}
