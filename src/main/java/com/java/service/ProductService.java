package com.java.service;

import com.java.entity.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);

    List<Product> findAllProduct();

    Product findProduct(int id);

    String deleteProduct(int id);
}
