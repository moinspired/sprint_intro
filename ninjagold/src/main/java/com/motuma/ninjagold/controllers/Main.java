package com.motuma.ninjagold.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Main {

	@RequestMapping("/")
	public String index(HttpSession session, Model model) {
		Integer gold = (Integer) session.getAttribute("gold");
		String messages =  (String) session.getAttribute("messages");
		
		System.out.println(messages);
		if(gold == null) {
			session.setAttribute("gold", 0);
		}
		if(messages == null) {
			session.setAttribute("messages", new ArrayList<String>());
		}
		model.addAttribute("GoldVal", gold);
		model.addAttribute("messages", messages);
		
		return "index.jsp";
	}
	
	@PostMapping("/process")
	public String process(@RequestParam("building") String building, HttpSession session, Model model) {
		Integer gold = (Integer) session.getAttribute("gold");
		String messages = "";
		Integer goldedEared = 0;
		Random rand = new Random();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm a");
		Date date = new Date();
		
		int totalGold = 0;
		if(building.equals("farm")) {
			goldedEared = rand.nextInt((20-10) + 1 ) + 10;
			totalGold = gold +  goldedEared;
			session.setAttribute("gold", totalGold); 
		}
		else if(building.equals("cave")) {
			goldedEared =  rand.nextInt((10-5) + 1 ) + 5;
			totalGold = gold + goldedEared;
			session.setAttribute("gold", totalGold); 
		}
		else if(building.equals("house")) {
			goldedEared = rand.nextInt((5-2) + 1 ) + 2;
			totalGold = gold +  goldedEared;
			session.setAttribute("gold", totalGold); 
		}
		
		else if(building.equals("casino")) {
			if(gold < 0) {
				
			}else {
				goldedEared = rand.nextInt((50+50) + 1 ) -50;
				totalGold = gold +  goldedEared;
				session.setAttribute("gold", totalGold); 
			}

		}
		
		messages = "You entered a " + building + " and earned " + goldedEared + " gold." + dateFormat.format(date)+ "\n";
		messages = session.getAttribute("messages") + messages;
		session.setAttribute("messages", messages);
		return "redirect:/";
	}
}
