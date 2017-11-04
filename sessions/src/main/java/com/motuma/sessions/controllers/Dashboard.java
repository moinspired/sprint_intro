package com.motuma.sessions.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("sessionAttribute")
public class Dashboard {
	 @ModelAttribute("sessionAttribute")
	    public String getSessionAttribute(){
	        return "Hawi";
	}
	@RequestMapping("/")
    public String index(@ModelAttribute("sessionAttribute") String sessionAttribute, SessionStatus sessionStatus) {
            System.out.println(sessionAttribute);
            sessionStatus.setComplete();
            return "index.jsp";
    }
}