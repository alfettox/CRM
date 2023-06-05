import { Component, OnInit } from '@angular/core';

import { DataService } from '../core/data.service';
import { ICustomer } from '../shared/Interfaces';

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
})
export class CustomersComponent implements OnInit {
  title: string = 'customer';
  people: any[] = [];

  constructor(private dataService: DataService) {}

  ngOnInit() {
    this.title = 'Customers';
    this.dataService
      .getCustomers()
      .subscribe((customers: ICustomer[]) => (this.people = customers));
  }
}
