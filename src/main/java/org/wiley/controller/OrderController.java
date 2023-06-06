package org.wiley.controller;

/* *
 * Abdullah Tariq, Riyad Argoub, Giovanni De Franceschi
 * Wiley Edge 2023
 * */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.wiley.dao.OrdersRepo;
import org.wiley.entity.Customer;
import org.wiley.entity.Order;

import java.util.List;

@RestController                                                            //TODO TO BE COMPLETED AND TESTED
@RequestMapping("/orders")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrdersRepo ordersRepo;

    public OrderController(OrdersRepo ordersRepo) {
        this.ordersRepo = ordersRepo;
    }

    @GetMapping("/")                                                //WORKS
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = ordersRepo.findAll();
        for (Order o : orders) {
            System.out.println(o.getCustomer() + ",  " + o.getQuantity());
        }
        return ResponseEntity.status(HttpStatus.OK).body(orders);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrder(@PathVariable("orderId") int orderId) {
        Order order = ordersRepo.findById(orderId).orElse(null);
        System.out.println(order.getCustomer() + ",  " + order.getQuantity());
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addNewCustomer(@RequestBody Order orders) {
        ordersRepo.save(orders);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("id") Integer id) {
        ordersRepo.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order) {
        ordersRepo.save(order);
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }

    @GetMapping("/cost/{customerId}")
    public ResponseEntity<List<Order>> getOrdersByCustomerId(@PathVariable Integer customerId) {
        List<Order> orders = ordersRepo.getOrdersByCustomerId(customerId);
        if (!orders.isEmpty()) {
            return ResponseEntity.ok(orders);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}


