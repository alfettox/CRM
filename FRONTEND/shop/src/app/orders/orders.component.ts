import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';

import { DataService } from '../core/data.service';
import { ICustomer, IOrder, IOrderItem } from '../shared/Interfaces';


@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css'],
})
export class OrdersComponent implements OnInit {
  orders: IOrder[] = [];
  customer: ICustomer | undefined;

  constructor(
    private dataService: DataService,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    let id = this.route.snapshot.paramMap.get('id');
    if (id !== null) {
      let customerId = +id;
      this.dataService.getOrders(customerId).subscribe((orders: IOrder[]) => {
        this.orders = orders;
      });

      this.dataService
        .getCustomer(customerId)
        .subscribe((customer: ICustomer | null) => {
          this.customer = customer || ({} as ICustomer); // Provide a default value if customer is null
        });
    }
  }
}
