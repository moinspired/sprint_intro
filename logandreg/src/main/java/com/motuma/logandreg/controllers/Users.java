package com.motuma.logandreg.controllers;

import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.motuma.logandreg.models.User;
import com.motuma.logandreg.services.UserService;

@Controller
public class Users {
    private UserService userService;
    
    public Users(UserService userService) {
        this.userService = userService;
    }
    
    @RequestMapping("/registration")
    public String registerForm(@Valid @ModelAttribute("user") User user) {
        return "logreg.jsp";
    }
    
    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
        if (result.hasErrors()) {
            return "logreg.jsp";
        }
        userService.saveWithUserRole(user);
        return "redirect:/login";
    }
    //session encrypted - pricipal
    @RequestMapping(value = {"/", "/home"})
    public String home(Principal principal, Model model) {
        // 1
        String username = principal.getName();
        User user = userService.findByUsername(username);
    	user.setUpdatedAt(new Date());
    	userService.update(user);
        
        model.addAttribute("currentUser", user);
        return "dashboard.jsp";
    }
    
    @RequestMapping("/login")
    public String login(@Valid @ModelAttribute("user") User user) {
        return "logreg.jsp";
    }
}