package com.java.controller;

import com.java.entity.Product;
import com.java.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products/v1")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Object> saveProduct(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.saveProduct(product));
    }

    @GetMapping
    public ResponseEntity<Object> findAllProduct() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findAllProduct());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findProduct(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(productService.findProduct(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.deleteProduct(id));
    }
}
