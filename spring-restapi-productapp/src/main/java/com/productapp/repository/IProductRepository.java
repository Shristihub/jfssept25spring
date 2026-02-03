package com.productapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productapp.model.entities.Product;

public interface IProductRepository extends JpaRepository<Product, Integer>{

}
