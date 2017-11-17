package com.motuma.beltreview.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.motuma.beltreview.models.Ring;
import com.motuma.beltreview.models.User;
import com.motuma.beltreview.services.RingService;
import com.motuma.beltreview.services.UserService;

@Controller
public class Rings {
	 private UserService userService;
	 private RingService ringService;
	 
	 public Rings(UserService userService, RingService ringService) {
		 this.userService = userService;
		 this.ringService = ringService;
	 }
	 
	 @RequestMapping("/ring_creater")
	 public String ringCreator() {
		 return "createRing.jsp";
	 }
	 
	 @PostMapping("/create/ring")
	 public String createRing(@RequestParam("ringValue") String ringValue, Ring ring) {
		 ring.setValue(ringValue);
		 ringService.create(ring);

		 return "redirect:/ring_creater";
	 }
	 
}
