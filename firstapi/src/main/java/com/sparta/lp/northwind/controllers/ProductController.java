package com.sparta.lp.northwind.controllers;

import com.sparta.lp.northwind.entities.CustomerEntity;
import com.sparta.lp.northwind.entities.ProductEntity;
import com.sparta.lp.northwind.nullGenerator;
import com.sparta.lp.northwind.repositories.CustomerRepository;
import com.sparta.lp.northwind.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    @Autowired
    public ProductController(CustomerRepository customerRepository, ProductRepository productRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }


    @GetMapping("/products/All/Raw")
    public List<ProductEntity> getAllProducts(){
        return productRepository.findAll();
    }
    @GetMapping("/products/specificID/{id}")
    public Optional<ProductEntity> getProductsById(@PathVariable(required = false) Integer id){
        if (id<78 && id>0) {
            return productRepository.findById(id);
        }
        ProductEntity productEntity= nullGenerator.noProducts();
        productEntity.setId(id);
        productEntity.setProductName("Invalid ID was chosen please try again.");
        return Optional.of(productEntity);

    }
}
