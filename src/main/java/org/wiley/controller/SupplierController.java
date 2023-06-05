package org.wiley.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/")
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        List<Supplier> suppliers = suppliersRepo.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(suppliers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Supplier> getSupplier(@PathVariable("id") int id) {
        Supplier supplier = suppliersRepo.findById(id).orElse(null);
        return new ResponseEntity<>(supplier, HttpStatus.OK);
}
    @PostMapping("/add")
    public ResponseEntity<Void> addNewSupplier(@RequestBody Supplier supplier) {
        suppliersRepo.save(supplier);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable("id") Integer id) {
        suppliersRepo.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    public ResponseEntity<Supplier> updateSupplier(@RequestBody Supplier supplier) {
        suppliersRepo.save(supplier);
        return new ResponseEntity<>(supplier, HttpStatus.OK);
    }
}



