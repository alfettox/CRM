import { Component } from '@angular/core';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent {
  name!: string;
  email!: string;
  message!: string;

  constructor(private toastr: ToastrService) { }

  sendEmail() {
    // Validate inputs
    if (!this.name || this.name.trim() === '') {
      this.toastr.error('Please enter your name.', 'Error');
      return;
    }

    if (!this.email || this.email.trim() === '') {
      this.toastr.error('Please enter your email address.', 'Error');
      return;
    }

    if (!this.isValidEmail(this.email)) {
      this.toastr.error('Please enter a valid email address.', 'Error');
      return;
    }

    if (!this.message || this.message.trim() === '') {
      this.toastr.error('Please enter your message.', 'Error');
      return;
    }

    // Sending email
    this.sendEmailToServer(this.name, this.email, this.message);

    // Show success message
    this.toastr.success('Email sent successfully!', 'Success');

    // Reset form inputs
    this.name = '';
    this.email = '';
    this.message = '';
  }

  isValidEmail(email: string) {
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email);
  }

  sendEmailToServer(name: string, email: string, message: string) {
    console.log('Sending email...');
    console.log('Name:', name);
    console.log('Email:', email);
    console.log('Message:', message);
  }
}
