package org.wiley.controller;

/* *
 * Abdullah Tariq, Riyad Argoub, Giovanni De Franceschi
 * Wiley Edge 2023
 * */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.wiley.dao.CustomersRepo;
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

    @GetMapping("/")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = ordersRepo.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable("id") int id) {
        Order order = ordersRepo.findById(id).orElse(null);
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
}
