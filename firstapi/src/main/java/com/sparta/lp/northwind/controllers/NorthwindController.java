package com.sparta.lp.northwind.controllers;

import com.sparta.lp.northwind.entities.CustomerEntity;
import com.sparta.lp.northwind.entities.ProductEntity;
import com.sparta.lp.northwind.nullGenerator;
import com.sparta.lp.northwind.repositories.CustomerRepository;
import com.sparta.lp.northwind.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class NorthwindController {
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    @Autowired
    public NorthwindController(CustomerRepository customerRepository, ProductRepository productRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    @GetMapping("/customers")
    @ResponseBody
    public List<CustomerEntity> getAllCustomers(@RequestParam(required = false) String name,
                                                @RequestParam(required = false) String city){
        if (name==null && city==null) {
            return customerRepository.findAll();
        }
        List<CustomerEntity> foundCustomer = new ArrayList<>();
        if (city==null) {
            for (CustomerEntity customerEntity :
                    customerRepository.findAll()) {
                if (customerEntity.getContactName().contains(name)) {
                    foundCustomer.add(customerEntity);
                }
            }
        }else if (name==null){
            for (CustomerEntity customerEntity :
                    customerRepository.findAll()) {
                if (customerEntity.getCity().contains(city)) {
                    foundCustomer.add(customerEntity);
                }
            }
        }else {
            for (CustomerEntity customerEntity :
                    customerRepository.findAll()) {
                if (customerEntity.getCity().contains(city) && customerEntity.getContactName().contains(name)) {
                    foundCustomer.add(customerEntity);
                }
            }
        }
        if (foundCustomer.size()==0){
            CustomerEntity j = new CustomerEntity();
            j.setId("null");
            j.setAddress("null");
            j.setCity("null");
            j.setCompanyName("null");
            j.setContactName("null");
            j.setCountry("null");
            j.setContactTitle("null");
            j.setPhone("null");
            j.setPostalCode("null");

            foundCustomer.add(j);
        }

        return foundCustomer;
    }

    @GetMapping("/products")
    public List<ProductEntity> getAllProducts(){
        return productRepository.findAll();
    }
    @GetMapping("/products/ID/{id}")
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
