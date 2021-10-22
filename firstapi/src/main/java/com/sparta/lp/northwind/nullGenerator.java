package com.sparta.lp.northwind;

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
}
