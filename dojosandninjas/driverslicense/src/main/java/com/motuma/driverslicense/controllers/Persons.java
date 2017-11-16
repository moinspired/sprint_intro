package com.motuma.driverslicense.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.motuma.driverslicense.models.Person;
import com.motuma.driverslicense.services.PersonService;



@Controller
public class Persons {
	private final PersonService personService;
	
	public Persons (PersonService personService) {
		this.personService = personService;
	}
	
	@RequestMapping("/person/new")
	public String newPerson(@ModelAttribute("person") Person person) {
		return "persons/new.jsp";
	}
	
	@PostMapping("/person/new")
	public String createNewPerson(@ModelAttribute("person") Person person,  BindingResult result) {
		if(result.hasErrors()) {
			return "persons/new.jsp";
		}
		else {
			personService.addPerson(person);
			return "redirect:/persons/new.jsp";
		}
	}
}
