package com.motuma.postrequest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
	@RequestMapping(path="/login", method=RequestMethod.POST)
	public String info(@RequestParam(value="user") String user, @RequestParam(value="password") String password) {
	// ... process information and save it to the session
		System.out.println("In the function");
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/dashboard")
		public String dashboard() {
			return "index.jsp";
		}
	
}
