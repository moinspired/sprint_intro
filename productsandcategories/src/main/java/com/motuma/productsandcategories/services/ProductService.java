package com.motuma.productsandcategories.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.motuma.productsandcategories.models.Product;
import com.motuma.productsandcategories.repositories.ProductRepository;

@Service
public class ProductService {
private ProductRepository productRepo;
	
	public ProductService(ProductRepository productRepo) {
		this.productRepo = productRepo;
	}
	
	public void create(Product product) {
		productRepo.save(product);
	}
	public List<Product> getProducts(){
		return (List<Product>) productRepo.findAll();
	}
	public Product getProduct(long id) {
		return (Product) productRepo.findOne(id);
	}
	public void update(Product product) {
		productRepo.save(product);
	}
	public void destroy(long id) {
		productRepo.delete(id);
	}
}
