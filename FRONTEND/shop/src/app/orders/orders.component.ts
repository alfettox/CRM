import { AuthService } from './../core/auth.service';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { catchError, forkJoin, map } from 'rxjs';
import { DataService } from '../core/data.service';
import { ICustomer, IOrder, IProduct } from '../shared/Interfaces';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css'],
})
export class OrdersComponent implements OnInit {
  customersOrderTotal: number = 0;
  title: string = 'Orders';
  products: any[] = [];
  customer: ICustomer | undefined;

  constructor(
    private dataService: DataService,
    private route: ActivatedRoute,
    private http: HttpClient,
    public AuthService: AuthService
  ) {}

  ngOnInit() {
    this.title = 'Orders';
    this.route.paramMap.subscribe((params) => {
      const customerId = params.get('id');
      console.log('Customer ID:', customerId); // Log the customer ID

      if (customerId) {
        const id = parseInt(customerId, 10);
        this.dataService.getProductsByOrder(id).subscribe((products: IProduct[]) => {
          this.products = products;
          console.log('Products:', products); // Log the products
        });
      }
    });
  }

  // getImageUrl(productName: string): string {
  //   const unsplashAccessKey = 'YOUR_UNSPLASH_ACCESS_KEY';
  //   const unsplashApiUrl = `https://api.unsplash.com/photos/random?query=${encodeURIComponent(productName)}&client_id=${unsplashAccessKey}`;
  
  //   return this.http.get<any>(unsplashApiUrl).pipe(
  //     map((response: any) => {
  //       return response.urls.regular;
  //     }),
  //     catchError((error: any) => {
  //       console.error('Failed to retrieve image from Unsplash:', error);
  //       return ''; // Return a default image URL or handle the error case
  //     })
  //   ).toPromise(); // Convert the Observable to a Promise and return the result synchronously
  // }
  
  
  
  
}

  //     if (customerId) {
  //       const id = parseInt(customerId, 10);
  //       const orders$ = this.dataService.getOrdersByCustomerId(id);
  //       const products$ = this.dataService.getProductsByOrder(id);

  //       forkJoin([orders$, products$]).subscribe(
  //         ([orders, products]) => {
  //           this.orders = orders;
  //           this.products = products;

  //           this.calculateOrderTotal();
  //         },
  //         (error) => {
  //           console.error(error);
  //         }
  //       );

  //       this.dataService
  //         .getCustomer(id)
  //         .subscribe((customer: ICustomer | null) => {
  //           this.customer = customer || ({} as ICustomer);
  //         });
  //     }
  //   });
  // }

  // calculateOrderTotal() {
  //   this.customersOrderTotal = 0;
  //   for (const order of this.orders) {
  //     const product = this.products.find((p) => p.productId === order.productId);
  //     if (product) {
  //       this.customersOrderTotal += order.quantity * product.productPrice;
  //     }
  //   }
  // }
// }