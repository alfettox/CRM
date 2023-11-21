package org.wiley.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.wiley.dao.CustomersRepo;
import org.wiley.dao.OrdersRepo;
import org.wiley.dao.ProductsRepo;
import org.wiley.dao.SuppliersRepo;
import org.wiley.entity.Supplier;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Giovanni De Franceschi
 * Wiley Edge
 **/

@SpringBootTest
class SupplierControllerTest {

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
        suppliersRepo.deleteAll();
    }

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
        suppliersRepo.save(supplier);
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

    @Transactional
    @Test
    void test_updateSupplier() {
        Supplier supplier = new Supplier();
        supplier.setSupplierId(555);
        supplier.setSupPhoneNum(123456789);
        suppliersRepo.save(supplier);

        assertEquals(1, suppliersRepo.findAll().size());

        Supplier savedSupplier = suppliersRepo.getById(555);
        savedSupplier.setSupEmail("thisIsTheNewEmail@testUpdate.com");
        suppliersRepo.save(savedSupplier);

        Supplier updatedSupplier = suppliersRepo.getById(555);
        assertEquals("thisIsTheNewEmail@testUpdate.com", updatedSupplier.getSupEmail());
    }

}
