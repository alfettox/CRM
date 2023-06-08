import { AuthService } from './../core/auth.service';
import { ApplicationRef, ChangeDetectorRef, Component, NgZone, OnInit } from '@angular/core';
import { DataService } from '../core/data.service';
import { ICustomer } from '../shared/Interfaces';
import { ActivatedRoute, Params } from '@angular/router';
import { PhoneNumberFormatPipe } from '../shared/phone.pipe';
@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.css'],
  providers: [PhoneNumberFormatPipe]
})
export class CustomersComponent implements OnInit {
  customers: ICustomer[] = [];
  filteredCustomers: ICustomer[] = [];
  customerIds: number[] = [];

  constructor(
    private dataService: DataService,
    private route: ActivatedRoute,
    private changeDetectorRef: ChangeDetectorRef,
    private ngZone: NgZone,
    public authService: AuthService
  ) {}

  reloadPage(): void {
    const parentUrl = location.href;
    window.location.reload();
    window.location.href = parentUrl;
  }

  ngOnInit(): void {
    this.route.queryParams.subscribe((params: Params) => {
      const customerIdParam = params['customerId'];
      if (customerIdParam) {
        this.customerIds = customerIdParam.split(',').map((customerId: string) => parseInt(customerId, 10));
      }
      this.fetchCustomers();
    });
  }

  fetchCustomers(): void {
    console.log('Fetching customers...');
    this.dataService.getCustomers().subscribe((customers: ICustomer[]) => {
      console.log('Received customers:', customers);
      this.customers = customers;
      this.applyFilter();
    });
  }

  applyFilter(): void {
    if (this.customerIds.length > 0) {
      this.filteredCustomers = this.customers.filter((customer: ICustomer) => this.customerIds.includes(customer.customerId));
    } else {
      this.filteredCustomers = this.customers;
    }
    console.log('Filtered customers:', this.filteredCustomers);
    this.ngZone.run(() => {
      this.changeDetectorRef.detectChanges();
    });
  }
} 