package org.wiley.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.wiley.dao.ProductsRepo;
import org.wiley.entity.Order;
import org.wiley.entity.Product;

import java.util.List;

/* *
 * Abdullah Tariq, Riyad Argoub, Giovanni De Franceschi
 * Wiley Edge 2023
 * */

@RestController                                                            //TODO TO BE COMPLETED AND TESTED
@RequestMapping("/products")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductsRepo productsRepo;

    public ProductController(ProductsRepo productsRepo) {
        this.productsRepo = productsRepo;
    }

    @GetMapping("/")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productsRepo.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") int id) {
        Product product = productsRepo.findById(id).orElse(null);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

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
