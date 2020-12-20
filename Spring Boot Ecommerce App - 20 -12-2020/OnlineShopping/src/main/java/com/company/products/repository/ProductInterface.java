package com.company.products.repository;

import org.springframework.data.repository.CrudRepository;

import com.company.products.entites.Products;

public interface ProductInterface extends CrudRepository<Products, Integer> {

}
