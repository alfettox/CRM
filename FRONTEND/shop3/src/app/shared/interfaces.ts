export interface ICustomer {
    id: number;
    name: string;
    city: string;
    orderTotal: number;
    customerSince: any;
}

export interface IOrder {
    customerId: number;
    orderItems: IOrderItem[];
}

export interface IOrderItem {
    id: number;
    productName: string;
    itemCost: number;
}


// export interface ICustomer {
//     id: number;
//     fName: string;
//     lName: string;
//     phoneNum: number;
//     shippingAddress: any;
// }

// export interface IOrder {
//     customerId: number;
//     orderItems: IOrderItem[];
// }

// export interface IOrderItem {
//     id: number;
//     productName: string;
//     itemCost: number;
// }