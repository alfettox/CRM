package org.wiley.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wiley.dao.CustomersRepo;
import org.wiley.dao.SuppliersRepo;
import org.wiley.entity.Customer;
import org.wiley.entity.Supplier;

import java.util.List;

/* *
 * Abdullah Tariq, Riyad Argoub, Giovanni De Franceschi
 * Wiley Edge 2023
 * */

@RestController
@RequestMapping("/suppliers")
@CrossOrigin
public class SupplierController {

    @Autowired
    private SuppliersRepo suppliersRepo;

    public SupplierController(SuppliersRepo suppliersRepo) {
        this.suppliersRepo = suppliersRepo;
    }

    @GetMapping("/")                                                                  //WORKS
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        List<Supplier> suppliers = suppliersRepo.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(suppliers);
    }
}

