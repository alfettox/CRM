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
  title: string = "Orders";
  orders: IOrder[] =
  [
    {
      "customerId": 1,
      "orderItems": [
        { "id": 1, "quantity": "2", "productId": 1, "customerId": 1 },
        { "id": 2, "quantity": "1", "productId": 2, "customerId": 1 }
      ]
    },
    {
      "customerId": 2,
      "orderItems": [
        { "id": 3, "quantity": "3", "productId": 3, "customerId": 2 },
        { "id": 4, "quantity": "1", "productId": 4, "customerId": 2 }
      ]
    },
    {
      "customerId": 3,
      "orderItems": [
        { "id": 5, "quantity": "1", "productId": 5, "customerId": 3 },
        { "id": 6, "quantity": "2", "productId": 6, "customerId": 3 }
      ]
    },
    {
      "customerId": 4,
      "orderItems": [
        { "id": 7, "quantity": "4", "productId": 7, "customerId": 4 },
        { "id": 8, "quantity": "2", "productId": 8, "customerId": 4 },
        { "id": 9, "quantity": "3", "productId": 9, "customerId": 4 }
      ]
    },
    {
      "customerId": 5,
      "orderItems": [
        { "id": 10, "quantity": "2", "productId": 10, "customerId": 5 },
        { "id": 11, "quantity": "3", "productId": 11, "customerId": 5 }
      ]
    },
    {
      "customerId": 6,
      "orderItems": [
        { "id": 12, "quantity": "1", "productId": 12, "customerId": 6 },
        { "id": 13, "quantity": "2", "productId": 13, "customerId": 6 }
      ]
    },
    {
      "customerId": 7,
      "orderItems": [
        { "id": 14, "quantity": "3", "productId": 14, "customerId": 7 },
        { "id": 15, "quantity": "1", "productId": 15, "customerId": 7 }
      ]
    },
    {
      "customerId": 8,
      "orderItems": [
        { "id": 16, "quantity": "2", "productId": 16, "customerId": 8 },
        { "id": 17, "quantity": "3", "productId": 17, "customerId": 8 },
        { "id": 18, "quantity": "1", "productId": 18, "customerId": 8 }
      ]
    },
    {
      "customerId": 9,
      "orderItems": [
        { "id": 19, "quantity": "3", "productId": 19, "customerId": 9 },
        { "id": 20, "quantity": "1", "productId": 20, "customerId": 9 }
      ]
    }
  ];
  customer: ICustomer | undefined;

  constructor(
    private dataService: DataService,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.title = 'Orders';
    let id = this.route.snapshot.paramMap.get('customerId');    //GET ID FROM URL, INSTEAD OF SUBSCRIBING THIS USED SNAPSHOT
    if (id !== null) {
      let customerId = parseInt(id, 10);
      this.dataService.getOrderById(customerId).subscribe((orders: IOrder[]) => {
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
