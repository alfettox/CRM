package org.wiley.controller;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.wiley.TestApplicationConfiguration;
import org.wiley.dao.CustomersRepo;
import org.wiley.dao.OrdersRepo;
import org.wiley.dao.ProductsRepo;
import org.wiley.dao.SuppliersRepo;
import org.wiley.entity.Customer;
import org.wiley.entity.Order;
import org.wiley.entity.Product;
import org.wiley.entity.Supplier;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Giovanni De Franceschi
 * Wiley Edge
 **/

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
class SupplierControllerTest {

    @Autowired
    SuppliersRepo suppliersRepo;

    @Autowired
    ProductsRepo productsRepo;

    @Autowired
    OrdersRepo ordersRepo;

    @Autowired
    CustomersRepo customersRepo;

//    @BeforeAll
//    public void setUp() {
//        List<Supplier> suppliers = new ArrayList<>();
//        for (Supplier supplier : suppliers) {
//            suppliers.add(suppliersRepo.save(supplier));
//
//        }
//        List<Product> products = new ArrayList<>();
//        for (Product product : products) {
//            products.add(productsRepo.save(product));
//        }
//
//        List<Order> orders = new ArrayList<>();
//        for (Order order : orders) {
//            orders.add(ordersRepo.save(order));
//        }
//
//        List<Customer> customers = new ArrayList<>();
//        for (Customer customer : customers) {
//            customers.add(customersRepo.save(customer));
//        }
//    }


    @Test
    void test_getAllSuppliers() {
        Supplier supplier1 = new Supplier();
        supplier1.setSupplierId(555);
        supplier1.setSupEmail("supplierEmailTest@gmail.com");
        supplier1.setSupPhoneNum(823654789);

        Supplier supplier2 = new Supplier();
        supplier2.setSupplierId(666);
        supplier2.setSupEmail("supplier2@gmail.com");
        supplier2.setSupPhoneNum(123654789);

        suppliersRepo.save(supplier1);
        suppliersRepo.save(supplier2);

        List<Supplier> suppliersFromDao = suppliersRepo.findAll();

        assertEquals(2, suppliersFromDao.size());
    }

    @Test
    void test_getSupplier() {
        Supplier supplier = new Supplier();
        supplier.setSupplierId(555);
        supplier.setSupEmail("sup@suppliers.com");
        supplier.setSupPhoneNum(123456798);
        List<Supplier> supplierListFromDao = suppliersRepo.findAll();
        assertEquals(1, supplierListFromDao.size());
        Supplier supplier1 = supplierListFromDao.get(0);
        assertEquals(555, supplier1.getSupplierId());
    }

    @Test
    void test_addNewSupplier() {
        Supplier newSupplier = new Supplier();
        newSupplier.setSupplierId(787);
        newSupplier.setSupEmail("sdasdsa@test.com");
        newSupplier.setSupPhoneNum(123456789);
        suppliersRepo.save(newSupplier);
        assertEquals(1, suppliersRepo.findAll().size());
        suppliersRepo.getById(787);
        assertEquals(787, newSupplier.getSupplierId());
    }

    @Test
    void test_deleteSupplier() {
        Supplier supplier = new Supplier();
        supplier.setSupplierId(555);
        supplier.setSupEmail("testDeleteSupplier@sup.com");
        supplier.setSupPhoneNum(123456789);
        suppliersRepo.save(supplier);
        assertEquals(1, suppliersRepo.findAll().size());
        suppliersRepo.deleteById(555);
        assertEquals(0, suppliersRepo.findAll().size());

    }

    @Test
    void test_updateSupplier() {
        Supplier supplier = new Supplier();
        supplier.setSupplierId(555);
        supplier.setSupEmail("testUpdateSup@mail.com");
        supplier.setSupPhoneNum(123456789);
        suppliersRepo.save(supplier);
        assertEquals(1, suppliersRepo.findAll().size());
        Supplier supplier1 = suppliersRepo.getById(555);
        supplier1.setSupEmail("thisIsTheNewEmail@testUpdate.com");
        suppliersRepo.save(supplier1);
        assertEquals("thisIsTheNewEmail@testUpdate.com", supplier1.getSupEmail());
    }
}
