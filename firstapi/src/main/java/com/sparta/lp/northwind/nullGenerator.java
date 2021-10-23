package com.sparta.lp.northwind;

import com.sparta.lp.northwind.entities.CustomerEntity;
import com.sparta.lp.northwind.entities.ProductEntity;

public class nullGenerator {
    public static ProductEntity noProducts(){
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(null);
        productEntity.setProductName("null");
        productEntity.setSupplierID(null);
        productEntity.setCategoryID(null);
        productEntity.setQuantityPerUnit("null");
        productEntity.setUnitPrice(null);
        productEntity.setUnitsInStock(null);
        productEntity.setUnitsOnOrder(null);
        productEntity.setDiscontinued(null);
        return productEntity;
    }
    public static CustomerEntity noCustomer(){
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId("null");
        customerEntity.setAddress("null");
        customerEntity.setCity("null");
        customerEntity.setCompanyName("null");
        customerEntity.setContactName("null");
        customerEntity.setCountry("null");
        customerEntity.setContactTitle("null");
        customerEntity.setPhone("null");
        customerEntity.setPostalCode("null");
        return customerEntity;
    }
}
