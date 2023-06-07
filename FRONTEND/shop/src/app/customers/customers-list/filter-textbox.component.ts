import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { OrderService } from '../../order.service';
import { IOrder, IProduct } from 'src/app/shared/Interfaces';
import { Location } from '@angular/common';
import { Router } from '@angular/router';


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

  reloadPage() {
    const currentUrl = this.router.url;
    window.location.reload();
    this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
      this.router.navigateByUrl(currentUrl);
    });
  }

  
  
  
  
  @Output() changed: EventEmitter<string> = new EventEmitter<string>();

  constructor(private router: Router) { }

  ngOnInit() {

  }
}
