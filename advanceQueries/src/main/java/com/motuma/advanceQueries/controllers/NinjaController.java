package com.motuma.advanceQueries.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NinjaController {
	@RequestMapping("")
	public String Home() {
		return "index.jsp";
	}
}
