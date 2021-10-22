package com.sparta.lp.northwind.repositories;

import com.sparta.lp.northwind.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
}
