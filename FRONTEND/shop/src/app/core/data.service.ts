import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';
import { map, catchError } from 'rxjs/operators';

import { ICustomer, IOrder } from '../shared/Interfaces';

@Injectable()
export class DataService {

    baseUrl: string = 'assets/';
    
    constructor(private http: HttpClient) { }

    getCustomer(id: number): Observable<ICustomer> {
      return this.http.get<ICustomer>(this.baseUrl + 'customers/' + id)
        // .pipe(
        //   catchError(this.handleError)
        // );
    }
    
    getOrders(id: number) : Observable<IOrder[]> {
      return this.http.get<IOrder[]>(this.baseUrl + 'orders.json')
        .pipe(
          map(orders => {
            let custOrders = orders.filter((order: IOrder) => order.customerId === id);
            return custOrders;
          }),
          // catchError(this.handleError)
        );
    }


    private handleError(error: any) {
      console.error('server error:', error);
      // if (error.error instanceof Error) {
          // const errMessage = error.error.message;
          // return Observable.throw(errMessage);
          // Use the following instead if using lite-server
          // return Observable.throw(err.text() || 'backend server error');
      // }
      // return Observable.throw(error || 'Node.js server error');
    }


    getCustomers() : Observable<ICustomer[]> {
      return this.http.get<ICustomer[]>(this.baseUrl + 'customers.json')
          // .pipe(
              // catchError(this.handleError)
          // );
  }

}