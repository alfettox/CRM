export interface ICustomer {
    id: number;
    name: string;
    orderTotal?: number | null;
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
