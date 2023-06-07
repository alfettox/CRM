package org.wiley.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.wiley.dao.CustomersRepo;
import org.wiley.dao.SuppliersRepo;
import org.wiley.entity.Customer;

import javax.persistence.EntityManager;
import java.util.List;

/* *
 * Abdullah Tariq, Riyad Argoub, Giovanni De Franceschi
 * Wiley Edge 2023
 * */

@RestController
@RequestMapping("/customers")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomersRepo customersRepo;
    private final SuppliersRepo suppliersRepo;

    public CustomerController(CustomersRepo customersRepo,
                              SuppliersRepo suppliersRepo) {
        this.customersRepo = customersRepo;
        this.suppliersRepo = suppliersRepo;
    }

    @GetMapping("/")                                                                  //WORKS
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customersRepo.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(customers);
    }

    @GetMapping("/{id}")                                                             //WORKS
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") int id) {
        Customer customer = customersRepo.findById(id).orElse(null);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping("/add")                                                            //TODO TO BE FIXED
    public ResponseEntity<Void> addNewCustomer(@RequestBody Customer customer) {
        customersRepo.save(customer);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")                                                                //WORKS
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") Integer id) {
        customersRepo.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")                                                           //TODO TO BE FIXED
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        customersRepo.save(customer);
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }


    @Autowired
    private EntityManager entityManager;

    @GetMapping("/supplier/{supEmail}")
    public ResponseEntity<List<Customer>> getAllCustomers(@PathVariable("supEmail") String supEmail) {
        String query = "SELECT c.* " +
                "FROM customer c " +
                "JOIN orders o ON c.customerId = o.customerId " +
                "JOIN orderProduct op ON o.orderId = op.orderId " +
                "JOIN product p ON op.productId = p.productId " +
                "JOIN productSupplier ps ON p.productId = ps.productId " +
                "JOIN supplier s ON ps.supplierId = s.supplierId " +
                "WHERE s.supEmail = :supEmail";


        List<Customer> filteredCustomers = entityManager.createNativeQuery(query, Customer.class)
                .setParameter("supEmail", supEmail)
                .getResultList();

        return ResponseEntity.status(HttpStatus.OK).body(filteredCustomers);
    }


}
