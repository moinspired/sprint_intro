package com.motuma.portfolioassignment.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("dojoName", "Burbank");
		return "index";
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
