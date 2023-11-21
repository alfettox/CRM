//This file contains all the methods that are used to fetch data from the server.

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable, throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators';

import { tap } from 'rxjs/operators';
import { ICustomer, IOrder, IProduct, ISupplier } from '../shared/Interfaces';

@Injectable()
export class DataService {
  baseUrl: string = 'http://localhost:8080/';

  constructor(private http: HttpClient) {}

  getCustomer(id: number): Observable<ICustomer> {
    return this.http
      .get<ICustomer[]>(this.baseUrl + 'customers.json')

      .pipe(catchError(this.handleError));
  }

  getCustomers(): Observable<ICustomer[]> {
    return this.http.get<ICustomer[]>(this.baseUrl + 'customers/').pipe(
      tap((data) => console.log(data)),
      catchError(this.handleError)
    );
  }

  getOrderById(id: number): Observable<IOrder[]> {
    return this.http.get<IOrder[]>(this.baseUrl + 'orders/').pipe(
      map((orders: any[]) => {
        let custOrders = orders.filter(
          (order: IOrder) => order.customerId === id
        );
        return custOrders;
      }),
      catchError(this.handleError)
    );
  }

  getProducts(): Observable<IProduct[]> {
    return this.http.get<IProduct[]>(this.baseUrl + 'products/').pipe(
      tap((data) => console.log(data)),
      catchError(this.handleError)
    );
  }


  // http://localhost:8080/products/orderid/158
  getProductsByOrder(orderId: number): Observable<any[]> {                     // <<< <<< <<<
    const url = `${this.baseUrl}products/orderid/${orderId}`;
    return this.http.get<any[]>(url);
  }
  

  getOrdersByCustomerId(customerId: number): Observable<any[]> {              // <<< <<< <<<
    const url = `${this.baseUrl}orders/customer/${customerId}`;
    return this.http.get<any[]>(url);
  }

  private handleError(error: any): Observable<any> {
    console.error('server error:', error);
    return throwError(error || 'Node.js server error');
  }

  fetchCustomersBySupplier(email: string): Observable<ICustomer[]> {
    console.log(email);
    console.log(`${this.baseUrl}customers/supplier/${email}`);
    return this.http.get<ICustomer[]>(`${this.baseUrl}customers/supplier/${email}`).pipe(
      catchError(this.handleError)
    );
  }
}
