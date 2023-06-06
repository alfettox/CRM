import { Injectable } from '@angular/core';
import { ICustomer } from '../shared/Interfaces';

@Injectable({
  providedIn: 'root',
})
export class CustomerDataService {
  static initialFilteredCustomers: ICustomer[] = [];
}
