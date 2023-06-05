import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { ICustomer } from '../../shared/interfaces';
import { filter } from 'rxjs';

@Component({
  selector: 'app-customers-list',
  templateUrl: './customers-list.component.html',
})
export class CustomersListComponent implements OnInit {
  private _customers: ICustomer[] = [];

  // @Input() customers: any[] = [];
  @Input() get customers(): ICustomer[] {
    return this._customers; //keep state when you unfilter
  }

  set customers(value: ICustomer[]) {
    if (value) {
      this.filteredCustomers = this._customers = value;
      this.calculateOrders();
    }
  }

  filteredCustomers: any[] = [];
  customersOrderTotal: number = 0;
  currencyCode: string = 'USD';

  constructor() {}

  ngOnInit() {}

  calculateOrders() {
    this.customersOrderTotal = 0;
    if (this.filteredCustomers != null || this.filteredCustomers != undefined) {
      this.filteredCustomers.forEach((cust: ICustomer) => {
        this.customersOrderTotal += cust.orderTotal;
      });
    }
  }

  sort(prop: string) {}

  filter(data: string) {
    if (data) {
      this.filteredCustomers = this.customers.filter((cust: ICustomer) => {
        return (
          cust.name.toLowerCase().indexOf(data.toLowerCase()) > -1 ||
          cust.city.toLowerCase().indexOf(data.toLowerCase()) > -1 ||
          cust.orderTotal.toString().indexOf(data) > -1
        );
      });

    } else {
      this.filteredCustomers = this.customers;
    }
    this.calculateOrders();
  }
}
