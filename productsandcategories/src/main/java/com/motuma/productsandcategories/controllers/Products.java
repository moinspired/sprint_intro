package com.motuma.productsandcategories.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Products {
	@RequestMapping("/products/new")
	public String newProduct() {
		return "/products/new.jsp";
	}
}
