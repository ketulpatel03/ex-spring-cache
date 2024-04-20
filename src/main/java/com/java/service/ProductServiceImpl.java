package com.java.service;

import com.java.entity.Product;
import com.java.respository.ProductRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @CacheEvict(value = "products", allEntries = true)
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    @Cacheable("products")
    public List<Product> findAllProduct() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("findAllProduct");
        return productRepository.findAll();
    }

    @Override
    public Product findProduct(int id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public String deleteProduct(int id) {
        productRepository.deleteById(id);
        return "product removed.";
    }
}
