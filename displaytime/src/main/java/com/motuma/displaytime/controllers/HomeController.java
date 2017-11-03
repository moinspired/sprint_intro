package com.motuma.displaytime.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller
public class HomeController {
	Date date = new Date();
	
    @RequestMapping("/")
    public String index() {
    	return "index";
    }
    @RequestMapping("/date")
    public String dateTemplate(Model model) {
    	DateFormat dateFormat = new SimpleDateFormat("EEEE, 'the' d 'of' MMMM, yyyy");
    	String dateVal =  dateFormat.format(date);
    	model.addAttribute("dateKey", dateVal);
		return "datePage";
    }
    @RequestMapping("/time")
    public String timeTemplate(Model model) {
    	DateFormat timeFormat = new SimpleDateFormat("HH:mm a");
    	String time = timeFormat.format(date);
    	model.addAttribute("timeKey", time);
    	return "timePage";
    }
}