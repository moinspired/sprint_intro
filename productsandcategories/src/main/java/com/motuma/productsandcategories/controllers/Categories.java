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
public class Categories {
	private final CategoryService categoryService;
	private final ProductService productService;
	
	public Categories(CategoryService categoryService, ProductService productService) {
		this.categoryService = categoryService;
		this.productService = productService;
	}
	@RequestMapping("/categories/new")
	public String newCatagory(@ModelAttribute("category") Category category) {
		return "/categories/new.jsp";
	}
	
	@PostMapping("/categories/new")
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "/categories/new.jsp";
		}else {
			categoryService.create(category);
			return "redirect:/categories/new";
		}
		
	}
	
	@RequestMapping("/categories/{id}")
	public String show(@PathVariable("id") Long id, @ModelAttribute("product") Product product, Model model) {
		model.addAttribute("category", categoryService.getCategory(id));
		model.addAttribute("allProducts", productService.getProducts());
		model.addAttribute("products", categoryService.getCategory(id).getProducts());
		return "categories/show.jsp";
	}
	
	@RequestMapping("/categories/{id}/addProduct")
	public String addProduct(@PathVariable("id") Long id, @RequestParam("product_id") Long product_id, Model model) {
		Category category = categoryService.getCategory(id);
		List<Product> products = category.getProducts();
		products.add(productService.getProduct(product_id));
		categoryService.update(category);
		
		return "redirect:/categories/{id}";
	}
}
