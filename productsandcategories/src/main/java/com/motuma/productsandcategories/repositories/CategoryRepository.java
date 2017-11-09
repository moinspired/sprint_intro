package com.motuma.productsandcategories.repositories;

import org.springframework.data.repository.CrudRepository;

import com.motuma.productsandcategories.models.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{
	
	
}
