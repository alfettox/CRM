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

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Giovanni De Franceschi
 * Wiley Edge
 **/
@SpringBootTest // (classes = TestApplicationConfiguration.class)
class CustomerControllerTest {
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
        customersRepo.deleteAll();
    }
    @Test
    void test_getAllCustomers() {
        Customer customer1 = new Customer();
        customer1.setCustomerId(1);
        customer1.setfName("Bill");
        customer1.setlName("Green");
        customersRepo.save(customer1);
        Customer customer2 = new Customer();
        customer2.setCustomerId(2);
        customer2.setfName("Steve");
        customer2.setlName("Smith");
        customersRepo.save(customer2);
        List<Customer> customersFromDao = customersRepo.findAll();
        assertEquals(2,customersFromDao.size());
        Customer retrievedCustomer1 = customersFromDao.get(0);
        assertEquals(1, retrievedCustomer1.getCustomerId());
        assertEquals("Bill", retrievedCustomer1.getfName());
        assertEquals("Green", retrievedCustomer1.getlName());
        Customer retrievedCustomer2 = customersFromDao.get(1);
        assertEquals(2, retrievedCustomer2.getCustomerId());
        assertEquals("Steve", retrievedCustomer2.getfName());
        assertEquals("Smith", retrievedCustomer2.getlName());
    }
    @Test
    void test_getCustomer() {
        Customer customer3 = new Customer();
        customer3.setCustomerId(3);
        customer3.setfName("Gary");
        customer3.setlName("Oak");
        customersRepo.save(customer3);
        Customer customer4 = new Customer();
        customer4.setCustomerId(4);
        customer4.setfName("Ash");
        customer4.setlName("Ketchum");
        customersRepo.save(customer4);
        Customer retrievedCustomer = customersRepo.findById(3).orElse(null);
        assertNotNull(retrievedCustomer);
        assertEquals(3, retrievedCustomer.getCustomerId());
        assertEquals("Oak", retrievedCustomer.getlName());
        assertEquals("Gary", retrievedCustomer.getfName());
    }
    @Test
    void test_addNewCustomer() {
        Customer newCustomer = new Customer();
        newCustomer.setCustomerId(5);
        newCustomer.setfName("Patrick");
        newCustomer.setlName("Star");
        customersRepo.save(newCustomer);
        List<Customer> customersFromDao = customersRepo.findAll();
        assertEquals("Patrick", customersFromDao.get(0).getfName());
        assertEquals("Star", customersFromDao.get(0).getlName());
        assertNotEquals(0, customersFromDao.size());
    }
    @Test
    void test_deleteCustomer() {
        Customer customer = new Customer();
        customer.setCustomerId(6);
        customer.setfName("Harold");
        customer.setlName("Flowers");
        customersRepo.save(customer);
        assertEquals(1, customersRepo.findAll().size());
        customersRepo.deleteById(6);
        assertEquals(0, customersRepo.findAll().size());
    }
    @Test
    void test_updateCustomer() {
        Customer customer = new Customer();
        customer.setCustomerId(7);
        customer.setfName("Lebron");
        customer.setlName("James");
        customersRepo.save(customer);
        Customer retrievedCustomer = customersRepo.findById(7).orElse(null);
        assertNotNull(retrievedCustomer);
        retrievedCustomer.setfName("Michael");
        retrievedCustomer.setlName("Jordan");
        customersRepo.save(retrievedCustomer);
        Customer updatedCustomer = customersRepo.findById(7).orElse(null);
        assertNotNull(updatedCustomer);
        assertEquals("Michael", updatedCustomer.getfName());
        assertEquals("Jordan",updatedCustomer.getlName());
    }
}
