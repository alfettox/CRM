import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { OrderService } from '../../order.service';
import { IOrder, IProduct } from 'src/app/shared/Interfaces';


@Component({
  selector: 'filter-textbox',
  template: ` Filter by customer: <input type="text" [(ngModel)]="filter" /> `,
  styleUrls: ['./filter-textbox.component.css'],
})
export class FilterTextboxComponent implements OnInit {
  private orderService!: OrderService;
  private _filter!: string;
  @Input() get filter() {
    return this._filter;
  }

  calculateTotal(order: IOrder, products: IProduct[]) {
    return this.orderService.calculateOrderTotal(order, products);
  }

  set filter(val: string) {
    this._filter = val;
    this.changed.emit(this.filter); //Raise changed event
  }

  @Output() changed: EventEmitter<string> = new EventEmitter<string>();

  constructor() {}

  ngOnInit() {

  }
}
