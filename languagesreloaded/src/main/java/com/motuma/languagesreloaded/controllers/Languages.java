package com.motuma.languagesreloaded.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.motuma.languagesreloaded.models.Language;
import com.motuma.languagesreloaded.services.LanguageService;

@Controller
public class Languages {
	private final LanguageService languageService;
	
	public Languages(LanguageService languageService) {
		this.languageService = languageService;
	}
	@RequestMapping("/")
	public String index(@ModelAttribute("language") Language language, Model model) {
		model.addAttribute("languages", languageService.getLanguages());
		return "index.jsp";
	}
	
	@PostMapping("/languages")
	public String createLanguages(@Valid @ModelAttribute("language") Language language, BindingResult result, Model model) {
		System.out.println("Inside languages");
		if(result.hasErrors()) {
			model.addAttribute("language",languageService.getLanguages());
			return "index.jsp";
		}
		else {
			languageService.addLanguage(language);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/languages/{id}")
	public String showLanguage(Model model, @PathVariable("id") Long id) {
    	Language lang = languageService.getLanguage(id);
    	model.addAttribute("id", id);
    	model.addAttribute("language", lang);
    	System.out.println(lang);
		return "show.jsp";
	}
}
