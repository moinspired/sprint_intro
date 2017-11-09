package com.motuma.productsandcategories.repositories;

import org.springframework.data.repository.CrudRepository;

import com.motuma.productsandcategories.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

}
