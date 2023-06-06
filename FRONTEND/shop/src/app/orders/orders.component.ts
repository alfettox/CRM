import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';

import { DataService } from '../core/data.service';
import { ICustomer, IOrder, IProduct } from '../shared/Interfaces';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css'],
})
export class OrdersComponent implements OnInit {
  title: string = 'Orders';
  orders: IOrder[] = [
    {
      "orderId": 1,
      "quantity": 2,
      "productId": 1,
      "customerId": 3
    },
    {
      "orderId": 2,
      "quantity": 3,
      "productId": 2,
      "customerId": 4
    },
    {
      "orderId": 3,
      "quantity": 1,
      "productId": 3,
      "customerId": 5
    }
  ];
  
  customer: ICustomer | undefined;

  constructor(
    private dataService: DataService,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.title = 'Orders';
    let id = this.route.snapshot.paramMap.get('customerId'); //GET ID FROM URL ONLY ONCE
    if (id !== null) {
      let customerId = parseInt(id, 10);
      this.dataService
        .getOrderById(customerId)
        .subscribe((orders: IOrder[]) => {
          this.orders = orders;
        });

      this.dataService
        .getCustomer(customerId)
        .subscribe((customer: ICustomer | null) => {
          this.customer = customer || ({} as ICustomer);
        });
    }
  }
}
