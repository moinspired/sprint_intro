package com.motuma.portfolioassignment.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index() {
		return "index.html";
	}
	
	@RequestMapping("/projects")
	public String projects() {
		return "portfolio.html";
	}
	@RequestMapping("/me")
	public String about() {
		return "about.html";
	}

}
