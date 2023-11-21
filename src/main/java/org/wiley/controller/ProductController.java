package org.wiley.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.wiley.dao.ProductsRepo;
import org.wiley.entity.Order;
import org.wiley.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* *
 * Giovanni De Franceschi
 * Wiley Edge 2023
 * */

@RestController                                                            //TODO TO BE COMPLETED AND TESTED
@RequestMapping("/products")
@CrossOrigin
public class ProductController {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private ProductsRepo productsRepo;

    public ProductController(ProductsRepo productsRepo) {
        this.productsRepo = productsRepo;
    }

    @GetMapping("/")                                                    //WORKS
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productsRepo.findAll();
        for(Product p : products){
            System.out.println(p.getProductName() + ", " + p.getProductPrice()+p.getProductId());
        }
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") int id) {
        Product product = productsRepo.findById(id).orElse(null);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }



//    @GetMapping("/orderid/{orderId}")
//    public ResponseEntity<List<Product>> getOrderProductsByOrder(@PathVariable("orderId") int orderId) {
//        String sqlQuery = "SELECT p.productId, o.orderId " +
//                "FROM product p " +
//                "INNER JOIN orderproduct op ON p.productId = op.productId " +
//                "INNER JOIN orders o ON op.orderId = o.orderId " +
//                "WHERE o.orderId = :orderId";
//
//        try {
//            List<Object[]> rows = entityManager.createNativeQuery(sqlQuery)
//                    .setParameter("orderId", orderId)
//                    .getResultList();
//
//            Map<Integer, Integer> orderProductMap = new HashMap<>();
//            for (Object[] row : rows) {
//                int pId = (int) row[0];
//                int oId = (int) row[1];
//                orderProductMap.put(pId, oId);
//            }
//
//            String jpql = "SELECT p FROM Product p";
//
//            List<Product> productList = entityManager.createQuery(jpql, Product.class)
//                    .getResultList();
//
//            String ordersQuery = "SELECT p FROM Product p";
//
//            List<Product> ordersList = entityManager.createQuery(ordersQuery, Product.class)
//                    .getResultList();
//            List<Product> filteredProducts = new ArrayList<>();
//            for (Product p : productList) {
//                if (orderProductMap.containsKey(p.getProductId())) {
//                    filteredProducts.add(p);
//                }
//            }
//            return new ResponseEntity<>(filteredProducts, HttpStatus.OK);
//        } catch (NoResultException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }



    @PostMapping("/add")
    public ResponseEntity<Void> addNewProduct(@RequestBody Product product) {
        productsRepo.save(product);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Integer id) {
        productsRepo.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    public ResponseEntity<Product> updateOrder(@RequestBody Product product) {
        productsRepo.save(product);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }
}
