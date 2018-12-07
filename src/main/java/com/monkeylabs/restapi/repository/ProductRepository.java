package com.monkeylabs.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.monkeylabs.restapi.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

	
}
