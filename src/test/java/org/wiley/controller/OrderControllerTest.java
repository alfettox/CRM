package org.wiley.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.wiley.dao.CustomersRepo;
import org.wiley.dao.OrdersRepo;
import org.wiley.dao.ProductsRepo;
import org.wiley.dao.SuppliersRepo;
import org.wiley.entity.Customer;
import org.wiley.entity.Order;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Giovanni De Franceschi
 * Wiley Edge
 **/
@SpringBootTest // (classes = TestApplicationConfiguration.class)
class OrderControllerTest {
    @Autowired
    SuppliersRepo suppliersRepo;

    @Autowired
    ProductsRepo productsRepo;

    @Autowired
    OrdersRepo ordersRepo;

    @Autowired
    CustomersRepo customersRepo;

    @BeforeEach
    public void clearTable() {
        ordersRepo.deleteAll();
    }


    @Test
    void getAllOrders() {
        Order order1 = new Order();
        order1.setOrderId(1);
        order1.setQuantity(4);
        ordersRepo.save(order1);

        Order order2 = new Order();
        order2.setOrderId(2);
        order2.setQuantity(7);
        ordersRepo.save(order2);

        List<Order> ordersFromDao = ordersRepo.findAll();
        assertEquals(2, ordersFromDao.size());

        Order retrievedOrder1 = ordersFromDao.get(0);
        assertEquals(1, retrievedOrder1.getOrderId());
        assertEquals(4, retrievedOrder1.getQuantity());

        Order retrievedOrder2 = ordersFromDao.get(1);
        assertEquals(2, retrievedOrder2.getOrderId());
        assertEquals(7, retrievedOrder2.getQuantity());

    }

    @Test
    void getOrder() {
        Order order3 = new Order();
        order3.setOrderId(3);
        order3.setQuantity(8);
        ordersRepo.save(order3);

        Order order4 = new Order();
        order4.setOrderId(4);
        order4.setQuantity(2);
        ordersRepo.save(order4);

        Order retrievedOrder = ordersRepo.findById(3).orElse(null);
        assertNotNull(retrievedOrder);
        assertEquals(3, retrievedOrder.getOrderId());
        assertEquals(8, retrievedOrder.getQuantity());
    }

    @Test
    void addNewCustomer() {
        Order newOrder = new Order();
        newOrder.setOrderId(5);
        newOrder.setQuantity(12);
        ordersRepo.save(newOrder);

        List<Order> ordersFromDao = ordersRepo.findAll();

        assertEquals(5, ordersFromDao.get(0).getOrderId());
        assertEquals(12, ordersFromDao.get(0).getQuantity());
        assertNotEquals(0, ordersFromDao.size());
    }

    @Test
    void deleteOrder() {
        Order order = new Order();
        order.setOrderId(6);
        order.setQuantity(1);
        ordersRepo.save(order);
        assertEquals(1, ordersRepo.findAll().size());
        ordersRepo.deleteById(6);
        assertEquals(0, ordersRepo.findAll().size());
    }

    @Test
    void updateOrder() {
        Order order = new Order();
        order.setOrderId(7);
        order.setQuantity(14);
        ordersRepo.save(order);

        Order retrievedOrder = ordersRepo.findById(7).orElse(null);
        assertNotNull(retrievedOrder);
        assertEquals(14, retrievedOrder.getQuantity());


        retrievedOrder.setQuantity(9);
        ordersRepo.save(retrievedOrder);

        Order updatedOrder = ordersRepo.findById(7).orElse(null);
        assertNotNull(updatedOrder);
        assertEquals(9, updatedOrder.getQuantity());
    }

//    @Test
//    void getOrdersByCustomerId() {
//        Customer customer = new Customer();
//        customer.setCustomerId(5198);
//        customer.setfName("Michelle");
//        customer.setlName("Obama");
//        customer.setEmail("mObama@gmail.com");
//        customer.setPhoneNum("123456789");
//        customer.setShippingAddress("123 White house street, Washington D.C");
//
//        Order order1 = new Order();
//        order1.setOrderId(11561);
//        order1.setQuantity(3);
//        order1.setCustomer(customer);
//        ordersRepo.save(order1);
//
//        List<Order> ordersByCustomerId = ordersRepo.getOrdersByCustomerId(customer.getCustomerId());
//        assertEquals(1, ordersByCustomerId.size());
//
//        Order retrievedOrder1 = ordersByCustomerId.get(0);
//        assertEquals(11, retrievedOrder1.getOrderId());
//        assertEquals(3, retrievedOrder1.getQuantity());
//        assertEquals(customer, retrievedOrder1.getCustomer());
//    }
}
