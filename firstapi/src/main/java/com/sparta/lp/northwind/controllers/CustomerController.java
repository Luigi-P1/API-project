package com.sparta.lp.northwind.controllers;

import com.sparta.lp.northwind.entities.CustomerEntity;
import com.sparta.lp.northwind.nullGenerator;
import com.sparta.lp.northwind.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {
    private final CustomerRepository customerRepository;
    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/Customers/ThatContains/Name/And/City")
    @ResponseBody
    public List<CustomerEntity> withNameAndCity(@RequestParam(required = false) String name,
                                               @RequestParam(required = false) String city){

        List<CustomerEntity> customersFound= customerRepository.findAll();
        if (name==null &&city==null){
            return customersFound;
        }
        CustomerEntity customerEntity;
        int len=customersFound.size();
        for (int i=0;i<len;i++) {
            if (i < customersFound.size()) {
                customerEntity = customersFound.get(i);
                if (name != null && !customerEntity.getContactName().contains(name)) {
                    customersFound.remove(customerEntity);
                    i--;
                } else if (city != null && !customerEntity.getCity().contains(city)) {
                    customersFound.remove(customerEntity);
                    i--;
                }

            }
        }
        if (customersFound.size()==0){
            customerEntity=nullGenerator.noCustomer();
            customerEntity.setCompanyName("No customer found with these specifications.");
            customersFound.add(customerEntity);
        }
        return customersFound;
    }
    @GetMapping("/Customers/ThatContains/Name/Or/City")
    @ResponseBody
    public List<CustomerEntity> withNameOrCity(@RequestParam(required = false) String name,
                                                @RequestParam(required = false) String city){

        List<CustomerEntity> customersFound= customerRepository.findAll();
        if (name==null &&city==null){
            return customersFound;
        }
        boolean hasName;
        boolean hasCity;
        CustomerEntity customerEntity;
        int len=customersFound.size();
        for (int i=0;i<len;i++) {
            hasName=true;
            hasCity=true;
            if (i< customersFound.size()){
                    customerEntity=customersFound.get(i);
                if ( name!=null&&!customerEntity.getContactName().contains(name)) {
                    hasName=false;
                 }
                if (city!=null&&!customerEntity.getCity().contains(city)){
                    hasCity=false;
            }
            if (!hasName&&!hasCity){
                customersFound.remove(customerEntity);
                i--;
            }
        }
        }
        if (customersFound.size()==0){
            customerEntity=nullGenerator.noCustomer();
            customerEntity.setCompanyName("No customer found with these specifications.");
            customersFound.add(customerEntity);
        }
        return customersFound;
    }
    @GetMapping("/Customers/All/AlphabeticalOrder/CompanyNames")
    public List<CustomerEntity> customersAlphaOrder(){
        List<CustomerEntity> customers= customerRepository.findAll();
        List<CustomerEntity> customersOrdered= new ArrayList<>();
        List<String> names=new ArrayList<>();
        for (CustomerEntity customerEntity: customers) {
            names.add(customerEntity.getCompanyName());
        }
        java.util.Collections.sort(names);
        for (String name:names) {
            for (CustomerEntity customerEntity:customers){
                if (customerEntity.getCompanyName().equals(name)){
                    customersOrdered.add(customerEntity);
                    break;
                }
            }
        }
        return customersOrdered;
    }
    @GetMapping("/Customers/All/GroupBy/Country")
    @ResponseBody
    public List<CustomerEntity> customersGroupedCity(){
        List<CustomerEntity> customers= customerRepository.findAll();
        List<String> countries=new ArrayList<>();
        List<CustomerEntity> customersGrouped=new ArrayList<>();
        for (CustomerEntity customerEntity:customers){
            if (!countries.contains(customerEntity.getCountry())){
                countries.add(customerEntity.getCountry());
            }
        }
        for (String country :countries) {
            for (CustomerEntity customerEntity: customers) {
                if (country.equals(customerEntity.getCountry())){
                    customersGrouped.add(customerEntity);
                }
            }
        }
        return customersGrouped;
    }
}
