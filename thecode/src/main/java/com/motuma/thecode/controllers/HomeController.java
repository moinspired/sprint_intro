package com.motuma.thecode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
	@RequestMapping("")
	public String index() {
		return "index.jsp";
	}
	@PostMapping("/code")
	public String index(@RequestParam("code") String code, RedirectAttributes redirectAttributes) {
		System.out.println(code);
		switch(code) {
			case "Loyalty": 
				code = "Loyalty";
				break;
			case "Courage": 
				break;
			case "Veracity": 
				break;
			case "Compassion": 
				break;
			case "Honor": 
				break;
			default:
				redirectAttributes.addFlashAttribute("errors", "You must train harder!");
		}
		return "redirect:/";
	}
	
}
