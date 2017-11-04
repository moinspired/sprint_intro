package com.motuma.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Dashboard {
	@RequestMapping("/")
	public String index(HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
		
		if(count == null) {
			session.setAttribute("count", 0);
			System.out.println("This is a session attrubte when null:" + session.getAttribute("count"));
		} else {
			Integer currentCount = count + 1;
			session.setAttribute("count", currentCount);
			System.out.println("Not null " + session.getAttribute("count"));
		}
		
		
		return "index.jsp";
	}	
	
	@RequestMapping("/counter")
	public String counter() {
		return "info.jsp";
	}
}
