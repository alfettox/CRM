package org.wiley.service;

import org.wiley.entity.Order;

import java.util.List;

public interface OrderServiceLayer {
    List<Order> getAllOrders();

    Order getOrder(int OrderId) throws OrderNotFoundException;

    void addOrder(Order order) throws OrderDataValidationException, OrderIdDuplicateException;
    void updateOrder(Order order) throws  OrderDataValidationException, OrderNotFoundException;
    void deleteOrder(int OrderId) throws  OrderNotFoundException;
}

