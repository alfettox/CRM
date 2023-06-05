import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs';
import { ICustomer, IOrder } from '../../app/shared/interfaces';

import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable()
export class DataService {

    baseUrl: string = 'http://localhost:8080/'; 
//   baseUrl: string = 'assets/';  //CHANGE THE URL TO USE OUR REST API JAVA<<<    

  private handleError(error: any): Observable<never> {
    console.error('server error:', error);
    if (error.error instanceof Error) {
      const errMessage = error.error.message;
      return throwError(errMessage).pipe(catchError(this.handleError));
    }
    return throwError(error || 'Node.js server error');
  }
    
  constructor(private http: HttpClient) { }

  getCustomers() : Observable<ICustomer[]> {                                                    //GET ALL CUSTOMERS                      
      return this.http.get<ICustomer[]>(this.baseUrl + 'customers.json')
          .pipe(
              catchError(this.handleError)
          );
  }
  
  getCustomer(id: number) : Observable<ICustomer | null > {                                    //GET SPECIFIC CUSTOMER
    return this.http.get<ICustomer[]>(this.baseUrl + 'customers.json')
      .pipe(
        map(customers => {
          let customer = customers.filter((cust: ICustomer) => cust.id === id);
          return (customer && customer.length) ? customer[0] : null;
        }),
        catchError(this.handleError)
      )
  }

  getOrders(id: number) : Observable<IOrder[]> {                                                //GET SPECIFIC ORDER
    return this.http.get<IOrder[]>(this.baseUrl + 'orders.json')
      .pipe(
        map(orders => {
          let custOrders = orders.filter((order: IOrder) => order.customerId === id);
          return custOrders;
        }),
        catchError(this.handleError)
      );
  }

}
