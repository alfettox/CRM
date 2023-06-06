import { Injectable } from '@angular/core';
import { IOrder, IProduct } from './shared/Interfaces';

@Injectable({
  providedIn: 'root',
})
export class OrderService {
  calculateOrderTotal(order: IOrder, products: IProduct[]): number {
    const product = products.find((p) => p.productId === order.productId);
    if (product) {
      return order.quantity * product.productPrice;
    }
    return 0;
  }
}
