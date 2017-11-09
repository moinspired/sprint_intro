package com.motuma.driverslicense.controllers;

import java.awt.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.motuma.driverslicense.models.Dojo;
import com.motuma.driverslicense.models.Ninja;
import com.motuma.driverslicense.services.DojoService;




@Controller
public class Dojos {
	private final DojoService dojoService;
	
	public Dojos(DojoService dojoService) {
		this.dojoService = dojoService;
	}

	@RequestMapping("/dojos/new")
	public String index(@Valid @ModelAttribute("dojo") Dojo dojo) {
		return "dojos/new.jsp";
	}
	
	@PostMapping("/dojos/new")
	public String add(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "dojos/new.jsp";
		}
		else {
			dojoService.addDojo(dojo);
			return "redirect:/dojos/new";
		}
	}
	@RequestMapping("dojo/{dojo_id}")
	public String showNinjas(@PathVariable("dojo_id") Long dojo_id, Model model, Dojo dojo) {
		model.addAttribute("dojo", dojoService.getDojo(dojo_id));
		model.addAttribute("ninjas", dojoService.getDojo(dojo_id).getNinjas());
		for (Ninja ninja: dojoService.getDojo(dojo_id).getNinjas()) {
			System.out.println(ninja.getFirstName());
		}
		return "/ninjas/show.jsp";
	}

}
