package com.motuma.productsandcategories.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.motuma.productsandcategories.models.Category;
import com.motuma.productsandcategories.repositories.CategoryRepository;


@Service
public class CategoryService {
	private CategoryRepository categoryRepo;
	
	public CategoryService(CategoryRepository categoryRepo) {
		this.categoryRepo = categoryRepo;
	}
	
	public void create(Category category) {
		categoryRepo.save(category);
	}
	public List<Category> getCategories(){
		return (List<Category>) categoryRepo.findAll();
	}
	public Category getCategory(long id) {
		return (Category) categoryRepo.findOne(id);
	}
	public void update(Category category) {
		categoryRepo.save(category);
	}
	public void destroy(long id) {
		categoryRepo.delete(id);
	}
}
