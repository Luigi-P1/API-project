package com.sparta.lp.northwind.repositories;

import com.sparta.lp.northwind.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
}