export interface ICustomer {
    id: number;
    fName: string;
    lName: string;
    phoneNum: string;
    shippingAddress: string;
    email: string;
    orderTotal?: number | null;
}

export interface IOrder {
    customerId: number;
    orderItems: IProduct[];
}

export interface IProduct {
    id: number;
    quantity: string;
    productId: number;
    customerId: number;
    
}
