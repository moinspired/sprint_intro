package com.motuma.productsandcategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.motuma.productsandcategories.models.Category;
import com.motuma.productsandcategories.models.Product;
import com.motuma.productsandcategories.services.CategoryService;
import com.motuma.productsandcategories.services.ProductService;

@Controller
public class Products {
	private final ProductService productService;
	private final CategoryService categoryService;
	
	public Products(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}
	
	@RequestMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "/products/new.jsp";
	}
	
	@PostMapping("/products/new")
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
	if(result.hasErrors()) {
		return "/products/new.jsp";
	}
		productService.create(product);
		return "redirect:/products/new";
	}

	@RequestMapping("/products/{id}")
	public String show(@PathVariable("id") Long id, Model model, @ModelAttribute("category") Category category) {
		model.addAttribute("product", productService.getProduct(id));
		model.addAttribute("product_categories", productService.getProduct(id).getCategories());
		model.addAttribute("categories", categoryService.getCategories());
		return "products/show.jsp";
		
	}
	
	@PostMapping("/products/{id}/addCategory")
	public String addCategory(@PathVariable("id") Long id, @RequestParam("category_id") Long category_id, Model model) {
		System.out.println(id);
		System.out.println(category_id);
		List<Category> categories = productService.getProduct(id).getCategories();
		System.out.println(categories);
		categories.add(categoryService.getCategory(category_id));
		productService.update(productService.getProduct(id));
		
		return "redirect:/products/{id}";
	}
}
