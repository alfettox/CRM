import { Component, OnInit, Input } from '@angular/core';

import { ICustomer } from '../../shared/Interfaces';
import { SorterService } from '../../core/sorter.service';

@Component({
  selector: 'app-customers-list',
  templateUrl: './customers-list.component.html',
})
export class CustomersListComponent implements OnInit {
  private _customers: ICustomer[] = [];
  @Input() get customers(): ICustomer[] {
    return this._customers;
  }

  set customers(value: ICustomer[]) {
    if (value) {
      this._customers = value;
      this.filteredCustomers = value;
      this.calculateOrders();
    }
  }

  filteredCustomers: any[] = [];
  customersOrderTotal: number = 0;
  currencyCode: string = 'CAD';

  constructor(private sorterService: SorterService) {}

  ngOnInit() {}

  calculateOrders() {
    this.customersOrderTotal = 0;
    this.filteredCustomers.forEach((cust: ICustomer) => {
      if (cust && cust.orderTotal !== undefined) {
        this.customersOrderTotal += cust.orderTotal || 0;
      }
    });
  }
  filter(data: string) {
    if (data) {
      this.filteredCustomers = this.customers.filter((cust: ICustomer) => {
        return (
          cust.fName.toLowerCase().indexOf(data.toLowerCase()) > -1 ||
          (cust.orderTotal !== undefined && cust.orderTotal !== null && cust.orderTotal.toString().indexOf(data) > -1)
        );
      });
    } else {
      this.filteredCustomers = this.customers;
    }
    this.calculateOrders();
  }
  

  sort(prop: string) {
    this.sorterService.sort(this.filteredCustomers, prop);
  }
}
