package com.sparta.lp.northwind.controllers;

import com.sparta.lp.northwind.entities.CustomerEntity;
import com.sparta.lp.northwind.nullGenerator;
import com.sparta.lp.northwind.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CustomerController {
    private final CustomerRepository customerRepository;
    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @GetMapping("/customers/Names&citiesThatContains")
    @ResponseBody
    public List<CustomerEntity> getAllCustomers(@RequestParam(required = false) String name,
                                                @RequestParam(required = false) String city){

        List<CustomerEntity> customersFound= customerRepository.findAll();
        for (CustomerEntity customerEntity :
                customersFound) {
            if (name != null && !customerEntity.getContactName().contains(name)) {
                customersFound.remove(customerEntity);
            }else if (city!=null && !customerEntity.getCity().contains(city)){
                customersFound.remove(customerEntity);
            }
        }

        if (customersFound.size()==0){
            CustomerEntity customerEntity=nullGenerator.noCustomer();
            customerEntity.setCompanyName("No customer found with these specifications.");
            customersFound.add(customerEntity);
        }
        return customersFound;
    }

}
