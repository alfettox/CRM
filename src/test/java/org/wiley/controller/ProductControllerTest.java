package org.wiley.controller;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.wiley.TestApplicationConfiguration;
import org.wiley.dao.CustomersRepo;
import org.wiley.dao.OrdersRepo;
import org.wiley.dao.ProductsRepo;
import org.wiley.dao.SuppliersRepo;
import org.wiley.entity.Order;
import org.wiley.entity.Product;
import org.wiley.entity.ProductCategory;
import org.wiley.entity.Supplier;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Giovanni De Franceschi
 * Wiley Edge
 **/

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
class ProductControllerTest {
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
//        List<Room> rooms = roomDao.getAllRooms();
//        for (Room room : rooms) {
//            roomDao.deleteRoomById(room.getId());
//        }
//
//        List<Employee> employees = employeeDao.getAllEmployees();
//        for (Employee employee : employees) {
//            employeeDao.deleteEmployeeById(employee.getId());
//        }
//
//        List<Meeting> meetings = meetingDao.getAllMeetings();
//        for (Meeting meeting : meetings) {
//            meetingDao.deleteMeetingById(meeting.getId());
//        }
//    }

    @Test
    void test_getAllProducts() {
        Product bread = new Product();
        bread.setProductId(232);
        bread.setProductName("Bread");
        bread.setProductPrice(BigDecimal.valueOf(2.99));
        productsRepo.save(bread);
        Product milk = new Product();
        milk.setProductId(233);
        milk.setProductPrice(BigDecimal.valueOf(12.30));
        milk.setProductName("Fresh milk");
        productsRepo.save(milk);
        Product cheese = new Product();
        cheese.setProductId(234);
        cheese.setProductName("Cheese");
        cheese.setProductPrice(BigDecimal.valueOf(3.99));
        productsRepo.save(cheese);
        ProductCategory dairy = new ProductCategory();
        List<Product> productsFromDao = productsRepo.findAll();
        assertEquals("Bread", productsFromDao.get(0).getProductName());
        assertEquals("Fresh milk", productsFromDao.get(1).getProductName());
        assertEquals("Cheese", productsFromDao.get(2).getProductName());
    }

    @Test
    void test_getProduct() {
        Product monitor = new Product();
        monitor.setProductId(235);
        monitor.setProductName("Monitor");
        monitor.setProductPrice(BigDecimal.valueOf(199.99));
        productsRepo.save(monitor);
        productsRepo.save(monitor);

        Product mouse = new Product();
        mouse.setProductId(236);
        mouse.setProductName("Mouse");
        mouse.setProductPrice(BigDecimal.valueOf(19.99));
        productsRepo.save(mouse);

        Optional<Product> monitorFromDao = productsRepo.findById(235);
        Product monitorFromDaoProduct = monitorFromDao.orElseThrow(() -> new NoSuchElementException("Product not found"));

        assertEquals(monitorFromDaoProduct.getProductName(), "Monitor");
        assertEquals(monitorFromDaoProduct.getProductPrice(), BigDecimal.valueOf(199.99));

    }

    @Test
    void test_addNewProduct() {
        Product fanWithColorLeds = new Product();
        fanWithColorLeds.setProductId(237);
        fanWithColorLeds.setProductName("Fan with color LEDs");
        fanWithColorLeds.setProductPrice(BigDecimal.valueOf(29.99));
        productsRepo.save(fanWithColorLeds);
        List<Product> ProductListFromDao = productsRepo.findAll();
        assertEquals("Fan with color LEDs", ProductListFromDao.get(0).getProductName());
        assertNotEquals(0, ProductListFromDao.size());
    }

    @Test
    void test_deleteProduct() {
        Product keyboard = new Product();
        keyboard.setProductId(238);
        keyboard.setProductName("Keyboard");
        keyboard.setProductPrice(BigDecimal.valueOf(19.99));
        productsRepo.save(keyboard);
        productsRepo.deleteById(238);
        List<Product> ProductListFromDao = productsRepo.findAll();
        assertEquals(0, ProductListFromDao.size());
        productsRepo.deleteById(235);


    }

    @Test
    void test_updateOrder() {
        Product headphones = new Product();
        headphones.setProductId(239);
        headphones.setProductName("Headphones");
        headphones.setProductPrice(BigDecimal.valueOf(49.99));
        productsRepo.save(headphones);
        Product headphonesFromDao = productsRepo.findById(239).orElseThrow(() -> new NoSuchElementException("Product not found"));
        headphonesFromDao.setProductName("Headphones with microphone");
        productsRepo.save(headphonesFromDao);
        Product headphonesFromDaoUpdated = productsRepo.findById(239).orElseThrow(() -> new NoSuchElementException("Product not found"));
        assertEquals("Headphones with microphone", headphonesFromDaoUpdated.getProductName());
    }
}
