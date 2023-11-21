import { AuthService } from './../core/auth.service';
import { AfterViewInit,Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { Observable, catchError, forkJoin, map, of } from 'rxjs';
import { DataService } from '../core/data.service';
import { ICustomer, IOrder, IProduct } from '../shared/Interfaces';
import { HttpClient } from '@angular/common/http';
import { MatDialog } from '@angular/material/dialog';
import { PopupComponent } from './../popup/popup.component';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css'],
})
export class OrdersComponent implements OnInit, AfterViewInit  {
  [x: string]: any;
  customersOrderTotal: number = 0;
  title: string = 'Orders';
  products: any[] = [];
  customer: ICustomer | undefined;
  orders!: any;
  image: string = './assets/images/placeholder.png';
  imageArr: string[] = [];
  orderCompletionStatus: any;

  constructor(
    private dataService: DataService,
    private route: ActivatedRoute,
    private http: HttpClient,
    public AuthService: AuthService,
    public dialog: MatDialog,

  ) {}

  ngOnInit() {

    this.title = 'Orders';
    this.route.paramMap.subscribe((params) => {
      const customerId = params.get('customerId');
      console.log('Customer ID:', customerId);

      if (customerId) {
        const id = parseInt(customerId, 10);

        this.dataService
          .getOrdersByCustomerId(id)
          .subscribe((orders: IOrder[]) => {
            this.orders = orders;
            console.log('Orders:', this.orders);

            const orderIdList = this.orders.map(
              (order: IOrder) => order.orderId
            );
            console.log('OrderId List:', orderIdList);
            this.callProductsApi(orderIdList);
          });
      }
    });


  }

  ngAfterViewInit() {
    setTimeout(() => {
      const addresses = this.extractShippingAddresses();
      console.log(">>>>>" + addresses);
    }, 1000);
  }

  extractShippingAddresses(): string[] {
    const addressElements = document.querySelectorAll('.orders-table tbody td:nth-child(7)');
    const shippingAddresses: string[] = [];

    addressElements.forEach((element: Element) => {
      const address = element.textContent?.trim() || '';
      shippingAddresses.push(address);
    });
    return shippingAddresses;
  }

  callProductsApi(orderIdList: number[]) {
    for (let id of orderIdList) {
      this.dataService
        .getProductsByOrder(id)
        .subscribe((products: IProduct[]) => {
          const order = this.orders.find((o: IOrder) => o.orderId === id);
          if (order) {
            order.products = products;
            console.log(products);
          }
        });
    }
  }
  isExpanded(order: any): boolean {
    return order.hasOwnProperty('expanded') ? order.expanded : false;
  }

  toggleProducts(order: any): void {
    order.expanded = !this.isExpanded(order);
  }

  getImage(productCategoryName: string): string {
    if (!productCategoryName) {
      return './assets/images/placeholder.png';
    } else {
      productCategoryName = productCategoryName.toLowerCase();
      switch (productCategoryName) {
        case 'electronics':
          return 'https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Arduino_ftdi_chip-1.jpg/320px-Arduino_ftdi_chip-1.jpg';
        case 'food':
          return 'https://upload.wikimedia.org/wikipedia/commons/thumb/6/6d/Good_Food_Display_-_NCI_Visuals_Online.jpg/320px-Good_Food_Display_-_NCI_Visuals_Online.jpg';
        case 'clothing':
          return 'https://upload.wikimedia.org/wikipedia/commons/thumb/7/79/Clothing_store_downtown_Boston.jpg/320px-Clothing_store_downtown_Boston.jpg';
        case 'books':
          return 'https://upload.wikimedia.org/wikipedia/commons/4/42/Otvorena_knjiga.JPG';
        case 'home appliances':
          return 'https://multimedia.bbycastatic.ca/multimedia/products/1500x1500/b00/b0017/b0017492.jpg';
        case 'toys':
          return 'https://www.ikea.com/ca/en/images/products/lillabo-toy-vehicle-mixed-colors__0877081_pe611027_s5.jpg?f=xl';
        default:
          return './../../assets/images/placeholder.jpg';
      }
    }
  }

  openPopup(shippingAddresses: string[]): void {
    this.dialog.open(PopupComponent, {
      data: { addresses: shippingAddresses }
    });
  }
}
