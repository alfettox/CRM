package org.wiley.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* *
 * Giovanni De Franceschi
 * Wiley Edge 2023
 * */


@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "orderId")
    private int orderId;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @ManyToMany
    @JoinTable(name = "orderproduct",
            joinColumns = @JoinColumn(name = "orderId"),
            inverseJoinColumns = @JoinColumn(name = "productId"))
    private List<Order> ordersList = new ArrayList<>();

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<Order> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Order> ordersList) {
        this.ordersList = ordersList;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (orderId != order.orderId) return false;
        if (quantity != order.quantity) return false;
        if (!Objects.equals(customer, order.customer)) return false;
        return Objects.equals(ordersList, order.ordersList);
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + quantity;
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        result = 31 * result + (ordersList != null ? ordersList.hashCode() : 0);
        return result;
    }

    public int getCustomerId() {
        return this.customer.getCustomerId();
    }


}
