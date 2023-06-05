import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable, throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators';

import { tap } from 'rxjs/operators';
import { ICustomer, IOrder, IProduct } from '../shared/Interfaces';

@Injectable()
export class DataService {

    // baseUrl: string = 'assets/';
    baseUrl: string = 'http://localhost:8080/'; //http://localhost:8080/customers

    constructor(private http: HttpClient) { }

    getCustomer(id: number): Observable<ICustomer> {
      return this.http.get<ICustomer[]>(this.baseUrl + 'customers.json')

        .pipe(
          catchError(this.handleError)
        );
    }



    getCustomers(): Observable<ICustomer[]> {
      return this.http.get<ICustomer[]>(this.baseUrl + 'customers/')
        .pipe(
          tap(data => console.log(data)),
          catchError(this.handleError)
        );
    }
    
    

    getOrderById(id: number): Observable<IOrder[]> {
      return this.http.get<IOrder[]>(this.baseUrl +'orders/')
        .pipe(
          map((orders: any[]) => {
            let custOrders = orders.filter((order: IOrder) => order.customerId === id);
            return custOrders;
          }),
          catchError(this.handleError)
        );
    }

    getProducts(): Observable<IProduct[]> {
      return this.http.get<IProduct[]>(this.baseUrl + 'products/')
        .pipe(
          tap(data => console.log(data)), 
          catchError(this.handleError)
        );
    }

    getOrdersByCustomerId(customerId: number): void {
      const url = `${this.baseUrl}orders?customerId=${customerId}`;
      this.http.get<IOrder[]>(url)   //change to an interface
      .pipe(
        map((orders: any[]) => {
          let custOrderById = orders.filter((order: IOrder) => order.customerId === customerId);
          return custOrderById;
        }),
        catchError(this.handleError)
      );
    }


    private handleError(error: any): Observable<any> {
      console.error('server error:', error);
      return throwError(error || 'Node.js server error');
    }


}

    // getOrders(id: number) : Observable<IOrder[]> {
    //   return this.http.get<IOrder[]>(this.baseUrl + 'orders.json')
    //     .pipe(
    //       map(orders => {
    //         let custOrders = orders.filter((order: IOrder) => order.customerId === id);
    //         return custOrders;
    //       }),
    //       // catchError(this.handleError)
    //     );
    // }

