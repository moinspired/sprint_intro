package com.motuma.admindashboard.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.motuma.admindashboard.models.Role;
import com.motuma.admindashboard.models.User;
import com.motuma.admindashboard.services.UserService;
import com.motuma.admindashboard.validator.UserValidator;

@Controller
public class Users {
    private UserService userService;
    
    // NEW
    private UserValidator userValidator;
    
    // NEW
    public Users(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }

	@RequestMapping("/registration")
	public String registerForm(@Valid @ModelAttribute("user") User user) {
		return "redirect:/login";
	}

	 @PostMapping("/registration")
	    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
	        // NEW
	        userValidator.validate(user, result);
	        if (result.hasErrors()) {
	            return "loginPage.jsp";
	        }
	        if(userService.getUsers().isEmpty()) {
	        	userService.saveUserWithAdminRole(user);
	        	System.out.println("saved as admin user.");
	        	return "redirect:/login";
	        }
	        
	        userService.saveWithUserRole(user);
	        System.out.println("saved as user.");
	        return "redirect:/login";
	    }
    @RequestMapping("/login")
    public String login(@ModelAttribute("user") User user, @RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successfull!");
        }
		model.addAttribute("loginMessage", "registration Successfull. Please Login!");
		return "loginPage.jsp";
	}
    
    @RequestMapping("/admin")
    public String adminPage(Principal principal, Model model) {
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        model.addAttribute("users", userService.getUsers());
        return "adminPage.jsp";
    }
    
    @RequestMapping(value = {"/", "/home"})
    public String home(Principal principal, Model model) {
        // 1
        String username = principal.getName();
        User user=userService.findByUsername(username);
        model.addAttribute("currentUser", userService.findByUsername(username));
        for(Role role: user.getRoles()) {
        	if(role.getName().equals("ROLE_ADMIN")) {
        		System.out.println("Loging in as a admin.");
        		return "redirect:/admin";
        	}		
        }
        System.out.println("Loging in as a user.");
        return "homePage.jsp";
    }
    
    @RequestMapping("/add/user/admin/{id}")
    public String updateUserWithAdmin(@PathVariable("id") Long id) {
    	userService.updateUserWithAdminRole(id);
    	return "redirect:/admin";
    }
    
    @RequestMapping("/delete/user/{id}")
    public String remove(@PathVariable("id") Long id) {
    	userService.deleteUser(id);
		return "redirect:/admin";
    	
    }
    
    
}
