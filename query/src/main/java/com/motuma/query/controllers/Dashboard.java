package com.motuma.query.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Dashboard {
	@RequestMapping("/")
    public String index(@RequestParam(value="q", required=false) String searchQuery) {
        return "You searched for " + searchQuery;
    }
}
