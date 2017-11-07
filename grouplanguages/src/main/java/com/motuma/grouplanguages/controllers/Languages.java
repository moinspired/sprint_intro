package com.motuma.grouplanguages.controllers;

import java.awt.print.Book;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.motuma.grouplanguages.models.Language;
import com.motuma.grouplanguages.services.LanguageService;

@Controller
public class Languages {
	private final LanguageService languageService;
	
	public Languages(LanguageService languageService) {
		this.languageService = languageService;
	}
 
    @RequestMapping("/languages")
    public String books(Model model) {
        List<Language> languages = languageService.allLangauge();
        model.addAttribute("languages", languages);
        return "languages.jsp";
    }
    @PostMapping("/languages/new")
    public String createBook(@ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
        	return "languages.jsp";
        }else{
            languageService.addLanguage(language);
            return "redirect:/languages";
        }
    }
    
    @RequestMapping("/languages/edit/{index}")
    public String editBook(@PathVariable("index") int id, Model model) {
        Language language = languageService.findLanguageByIndex(id);
        if (language != null){
            model.addAttribute("language", language);
            return "editLanguage.jsp";
        }else{
            return "redirect:/editlanguages";
        }
    }
    
    @PostMapping("/languages/edit/{index}")
    public String updateBook(@PathVariable("index") int index, @Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
        	return "editLanguage.jsp";
        }else{
        	languageService.updateLanguage(index, language);
        	return "redirect:/languages";
        }
    }
    
    
    @RequestMapping(value="/languages/delete/{id}")
    public String destroyBook(@PathVariable("id") int id) {
        languageService.destroyLanguage(id);
        return "redirect:/languages";
    }
    
}