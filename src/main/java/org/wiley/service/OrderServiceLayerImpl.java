package org.wiley.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.wiley.dao.OrdersRepo;
import org.wiley.entity.Order;

import java.util.List;
import java.util.Optional;

public class OrderServiceLayerImpl implements OrderServiceLayer {
    private OrdersRepo ordersRepo;

    @Autowired
    public OrderServiceLayerImpl(OrdersRepo ordersRepo) {
        this.ordersRepo = ordersRepo;
    }
    @Override
    public List<Order> getAllOrders() {
        return ordersRepo.findAll();
    }

    @Override
    public Order getOrder(int orderId) throws OrderNotFoundException {
        Optional<Order> optionalOrder = ordersRepo.findById(orderId);
        if (optionalOrder.isEmpty()) {
            throw new OrderNotFoundException("Order not found with ID: " + orderId);
        }
        return optionalOrder.get();
    }


    @Override
    public void addOrder(Order order) throws OrderDataValidationException, OrderIdDuplicateException {
        validateOrderData(order);
        checkOrderIdDuplication(order.getOrderId());
        ordersRepo.save(order);
    }


    @Override
    public void updateOrder(Order order) throws OrderDataValidationException, OrderNotFoundException {
        validateOrderData(order);
        checkOrderExistence(order.getOrderId());
        ordersRepo.save(order);
    }


    @Override
    public void deleteOrder(int orderId) throws OrderNotFoundException {
        checkOrderExistence(orderId);
        ordersRepo.deleteById(orderId);
    }
    private void validateOrderData(Order order) throws OrderDataValidationException {
        if (order.getQuantity() <= 0) {
            throw new OrderDataValidationException("Quantity must be greater than zero");
        }
    }
    private void checkOrderIdDuplication(int orderId) throws OrderIdDuplicateException {
        Optional<Order> optionalOrder = ordersRepo.findById(orderId);
        if (optionalOrder.isPresent()) {
            throw new OrderIdDuplicateException("Order ID already exists: " + orderId);
        }
    }
    private void checkOrderExistence(int orderId) throws OrderNotFoundException {
        Optional<Order> optionalOrder = ordersRepo.findById(orderId);
        if (optionalOrder.isEmpty()) {
            throw new OrderNotFoundException("Order not found with ID: " + orderId);
        }
    }

}
