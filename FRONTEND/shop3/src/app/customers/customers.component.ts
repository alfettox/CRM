import { DataService } from './../core/data.service';
import { Component, OnInit } from '@angular/core';
import 'bootstrap/dist/js/bootstrap.min.js';
import { ICustomer } from '../shared/interfaces';

@Component({
    selector: 'app-customers',
    templateUrl: './customers.component.html'
})
export class CustomersComponent implements OnInit {
[x: string]: any;
    title: string='';
    people: ICustomer[]=[];
    isVisible : boolean = false;

    showTitle(){
        this.isVisible = !this.isVisible;
    }
    
    constructor(private dataService : DataService) {}
    
    ngOnInit() {
        this.title = 'ONLINE shop';
        this.dataService.getCustomers()             //ASYNC OPERATION NEED TO BE SUBSCRIBED 
            .subscribe((customers: ICustomer[]) => this.people = customers);

        // this.people = [
        //     { id: 1, name: 'Jean Dupont', city: 'Montréal', orderTotal: 9.99, customerSince: new Date(2014, 7, 10) },
        //     { id: 2, name: 'Jane Doe', city: 'Chandler', orderTotal: 19.99, customerSince: new Date(2017, 2, 22)},
        //     { id: 3, name: 'Michelle Thomas', city: 'Seattle', orderTotal: 99.99, customerSince: new Date(2002, 10, 31)},
        //     { id: 4, name: 'Jim Thomas', city: 'New York', orderTotal: 599.99, customerSince: new Date(2002, 10, 31)},
        //     { id: 5, name: 'Pierre Martin', city: 'Montréal', orderTotal: 49.99, customerSince: new Date(2019, 5, 15) },
        //     { id: 6, name: 'Lucie Tremblay', city: 'Montréal', orderTotal: 129.99, customerSince: new Date(2018, 8, 3) },
        //     { id: 7, name: 'Robert Johnson', city: 'New York', orderTotal: 799.99, customerSince: new Date(2015, 3, 19) },
        //     { id: 8, name: 'Émilie Lefebvre', city: 'Montréal', orderTotal: 299.99, customerSince: new Date(2016, 11, 8) },
        //     { id: 9, name: 'David Smith', city: 'New York', orderTotal: 349.99, customerSince: new Date(2013, 6, 27) },
        //     { id: 10, name: 'Sophie Gagnon', city: 'Montréal', orderTotal: 199.99, customerSince: new Date(2020, 2, 11) },
        //   ];

    }
}