// This interfaces defines the objects properties and types of the project.

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

export interface ISupplier {
    supplierId: number;
    supPhoneNum: string;
    supEmail: string;
}
