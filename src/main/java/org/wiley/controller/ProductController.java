package org.wiley.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wiley.dao.ProductsRepo;

/* *
 * Abdullah Tariq, Riyad Argoub, Giovanni De Franceschi
 * Wiley Edge 2023
 * */

@RestController
@RequestMapping("/api/")
public class ProductController {


    @Autowired
    private ProductsRepo productRepo;


    @GetMapping
    public ResponseEntity<String> getHello() {
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }
}


