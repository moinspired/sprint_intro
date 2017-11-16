package com.motuma.driverslicense.controllers;

import java.util.Random;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.motuma.driverslicense.models.License;
import com.motuma.driverslicense.services.LicenseService;
import com.motuma.driverslicense.services.PersonService;


@Controller
public class Licenses {
	private final LicenseService licenseService;
	private final PersonService personService;
	private long count=0;
	
	public Licenses(LicenseService licenseService, PersonService personservice) {
		this.licenseService = licenseService;
		this.personService = personservice;
	}

	
	@RequestMapping("/license/new")
	public String newLicense(@ModelAttribute("license") License license,  BindingResult result, Model model) {
		model.addAttribute("persons", personService.getPersons());
		return "/licenses/new.jsp";
	}
	
	@PostMapping("/license/new")
	public String createLicense(@Valid @ModelAttribute License license, BindingResult result, Model model) {
		if(result.hasErrors()) {
			System.out.println("Error");
			model.addAttribute("persons", personService.getPersons());
			return "/licenses/new.jsp";
		} else {
			Random random = new Random();
			String randVal = Long.toString(random.nextLong());
	
			license.setNumber(randVal);
			licenseService.addLicense(license);
			
			System.out.println("success");
			return "redirect:/license/new";
		}
	}
	
}
