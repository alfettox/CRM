import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../core/auth.service';
@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.css'],
})
export class ItemListComponent {
  constructor(private router: Router, private authService: AuthService) {}
  isLoginPage: boolean = false;
  nextPage() {
    throw new Error('Method not implemented.');
  }
  prevPage() {
    throw new Error('Method not implemented.');
  }
  currentPage: any;
  totalPages: any;
  resetQuantity(_t6: {
    id: number;
    name: string;
    price: number;
    quantity: number;
    image: string;
  }) {
    throw new Error('Method not implemented.');
  }
  decreaseQuantity(_t6: {
    id: number;
    name: string;
    price: number;
    quantity: number;
    image: string;
  }) {
    throw new Error('Method not implemented.');
  }
  increaseQuantity(_t6: {
    id: number;
    name: string;
    price: number;
    quantity: number;
    image: string;
  }) {
    throw new Error('Method not implemented.');
  }
  itemsPerPage = 6;

  products = [
    {
      id: 1,
      name: 'Product 1',
      price: 10.99,
      quantity: 0,
      image: 'product1.jpg',
    },
    {
      id: 2,
      name: 'Product 2',
      price: 15.99,
      quantity: 0,
      image: 'product2.jpg',
    },
  ];
}
