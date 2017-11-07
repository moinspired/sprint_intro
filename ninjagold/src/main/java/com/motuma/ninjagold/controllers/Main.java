package com.motuma.ninjagold.controllers;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Main {
	public Random random = new Random();
	private String res;
	
	
	@RequestMapping("/gold")
	public String index(HttpSession session) {
		if(session.getAttribute("gold") == null)
			session.setAttribute("gold", 0);
		if (session.getAttribute("activities") == null)
			session.setAttribute("activities", new ArrayList<String>());
		return "index.jsp";
	}

	@PostMapping("/process")
	public String process(	@RequestBody() String body, Model model, HttpSession session) {
		
		System.out.println(body);
		
		body  = body.substring(0, body.indexOf("="));
		int result = 0;
		res = "You entered a ";
		switch(body) {
			case "farm":
				result = random.nextInt(10) +  10;
				break;
			case "cave":
				result = random.nextInt(5) +  5;
				break;
			case "house":
				result = random.nextInt(3) +  2;
				break;
			case "casino":
				result = random.nextInt(50);
				result = random.nextInt(2) + 1 == 1? result : -result;
				break;
			}
		res += body + " and earened " + result + "gold.";
		session.setAttribute("gold", (int)session.getAttribute("gold") + result);
		ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
		activities.add(res);
		session.setAttribute("activities", activities);
	
		return "redirect:/gold";
		
	}
}
