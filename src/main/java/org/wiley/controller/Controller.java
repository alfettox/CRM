package org.wiley.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/* *
 * Abdullah Tariq, Riyad Argoub, Giovanni De Franceschi
 * Wiley Edge 2023
 * */

@RestController
@RequestMapping("/api/")
public class Controller {


//@Autowired
//private Repo repo;


    @GetMapping
    public ResponseEntity<String> getHello() {
        return new ResponseEntity<>("Hello World", HttpStatus.OK)
    }
}


