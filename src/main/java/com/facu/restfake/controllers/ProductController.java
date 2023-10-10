package com.facu.restfake.controllers;

import com.facu.restfake.entities.Product;
import com.facu.restfake.services.ProductServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "fakestoreapi.com/products")
public class ProductController extends BaseControllerImpl<Product, ProductServiceImpl>{
    @GetMapping("/higher")
    public ResponseEntity<?> searchPriceHigherThan(@RequestParam Double minimumPrice) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchPriceHigherThan(minimumPrice));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
    @GetMapping("/between")
    public ResponseEntity<?> searchPriceBetween(@RequestParam Double minimumPrice, @RequestParam Double maximumPrice) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchPriceBetween(minimumPrice, maximumPrice));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
}
