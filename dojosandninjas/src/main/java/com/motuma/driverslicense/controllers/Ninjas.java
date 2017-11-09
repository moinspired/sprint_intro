package com.motuma.driverslicense.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.motuma.driverslicense.models.Ninja;
import com.motuma.driverslicense.services.DojoService;
import com.motuma.driverslicense.services.NinjaService;

@Controller
public class Ninjas {
	private final NinjaService ninjaService;
	private final DojoService dojosService;
	
	
	public Ninjas(NinjaService ninjaService, DojoService dojoService) {
		this.ninjaService = ninjaService;
		this.dojosService = dojoService;
	}

	
	@RequestMapping("/ninja/new")
	public String show(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("dojos", dojosService.getDojos());
		return "ninjas/new.jsp";
	}
	
	@PostMapping("/ninja/new")
	public String ninja(@ModelAttribute("ninja") Ninja ninja, Model model, BindingResult result) {
		if(result.hasErrors()) {
			return "ninjas/new.jsp";
		}
		else {
			ninjaService.addNinja(ninja);
			return "redirect:/ninja/new";
		}
	}
	
}
