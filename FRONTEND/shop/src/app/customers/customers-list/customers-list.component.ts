import { DataService } from '../../core/data.service';
import { Component, OnInit, Input } from '@angular/core';
import { ICustomer, IProduct } from '../../shared/Interfaces';
import { SorterService } from '../../core/sorter.service';
import { CustomerDataService } from '../../core/customerDataService'; //TODO NOT WORKING AS EXPECTED
import { OrderService } from './../../order.service';


@Component({
  selector: 'app-customers-list',
  templateUrl: './customers-list.component.html',
})
export class CustomersListComponent implements OnInit {
reloadPage() {
throw new Error('Method not implemented.');
}
  @Input() customers: ICustomer[] = [];
  @Input() filteredCustomers: ICustomer[] = [];
  customersOrderTotal: number = 0;
  currencyCode: string = 'CAD';
  

  constructor(
    private sorterService: SorterService,
    private customerDataService: CustomerDataService,
    private dataService: DataService,
    private orderService: OrderService


  ) {}

  ngOnInit() {
    this.filter('');
  }

  calculateTotal(order: any, products: IProduct[]) {
    return this.orderService.calculateOrderTotal(order, products);
  }

  calculateOrders(customer :ICustomer){
    this.dataService.getOrdersByCustomerId(customer.customerId).subscribe((orders) => {
      customer.orderTotal = orders.reduce((total, order) => {
        return total + order.quantity;
      }, 0);
      this.calculateAllOrdersOnCurrPage();
    });
  }

  calculateAllOrdersOnCurrPage() {
    this.customersOrderTotal = this.filteredCustomers.reduce((total, cust) => {
      return total + (cust.orderTotal || 0);
    }, 0);
  }

  filter(data: string) {
    let tempFilteredCustomers: ICustomer[];
  
    if (data) {
      tempFilteredCustomers = this.filteredCustomers.filter((
        cust: ICustomer) => {
        return (
          cust.customerId.toString().toLowerCase().includes(data.toLowerCase()) ||
          cust.fName.toLowerCase().includes(data.toLowerCase()) ||
          cust.lName.toLowerCase().includes(data.toLowerCase()) ||
          cust.phoneNum.toLowerCase().includes(data.toLowerCase()) ||
          cust.shippingAddress.toLowerCase().includes(data.toLowerCase()) ||
          cust.email.toLowerCase().includes(data.toLowerCase()) ||
          (cust.orderTotal !== undefined &&
            cust.orderTotal !== null &&
            cust.orderTotal.toString().includes(data)) //for each customer call this dataservice method getOrdersByCustomerId
        );
      });
    } else {
      tempFilteredCustomers = [...CustomerDataService.initialFilteredCustomers];
    }
  
    this.filteredCustomers = tempFilteredCustomers; //TODO NOT RESTORING THE INITIAL FILTERED CUSTOMERS WHEN INPUT DELETED
    this.calculateAllOrdersOnCurrPage();
  }
  
  sort(prop: string) {
    this.sorterService.sort(this.filteredCustomers, prop);
  }
  
}
