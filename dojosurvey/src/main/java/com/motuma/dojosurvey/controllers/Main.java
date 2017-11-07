package com.motuma.dojosurvey.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Main {
	@RequestMapping("/")
    public String index() {
		return "index.jsp";
    }
    
	@RequestMapping(value="/result", method=RequestMethod.POST)
	public String result(
			@RequestParam("name") String name, 
			@RequestParam("location") String location,
			@RequestParam("language") String language,
			@RequestParam("comment") String comment,
			Model model) {
		System.out.println(name);
		System.out.println(location);
		System.out.println(language);
		model.addAttribute("name", name);
		model.addAttribute("location", location);
		model.addAttribute("language", language);
		model.addAttribute("comment", comment);
		return "result.jsp";
	}
}