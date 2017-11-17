package com.motuma.beltreview.controllers;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.motuma.beltreview.models.Ring;
import com.motuma.beltreview.models.Team;
import com.motuma.beltreview.models.User;
import com.motuma.beltreview.services.RingService;
import com.motuma.beltreview.services.TeamService;
import com.motuma.beltreview.services.UserService;
import com.motuma.beltreview.validator.UserValidator;

@Controller
public class Users {
    private UserService userService;
    private RingService ringService;
    private UserValidator userValidator;
    private TeamService teamService;

    public Users(UserService userService, UserValidator userValidator, RingService ringService, TeamService teamService) {
        this.userService = userService;
        this.userValidator = userValidator;
        this.ringService = ringService;
        this.teamService = teamService;
    }
    
    @RequestMapping("/registration")
    public String registerForm(@Valid @ModelAttribute("user") User user) {
    	return "redirect:/login";
    }
    
    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
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
        
    @RequestMapping("/admin")
    public String adminPage(Principal principal, Model model) {
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        return "homePage.jsp";
    }
    
    
    @RequestMapping("/make/admin/{id}")
    public String makeAdmin(@PathVariable Long id) {
    	User user = userService.getUser(id);
    	userService.updateUserWithAdminRole(user);
    	return "redirect:/fool_creator";
    }
    @RequestMapping("/login")
    public String login(@Valid @ModelAttribute("user") User user, @RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successfull!");
        }
      
        return "loginPage.jsp";
    }
    
    @RequestMapping(value = {"/", "/home"})
    public String home(Principal principal, Model model) {
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        model.addAttribute("rings", ringService.getRings());       
  
        return "homePage.jsp";
    }
    
	 @PostMapping("/bind")
	 public String bindRings(Principal principal, Model model, @RequestParam("ring_id") long id) {
		 String username = principal.getName();
		 User user = userService.findByUsername(username);
		 
		 Ring ring  = ringService.getRing(id);
		 ring.setUser(user);
		 ringService.update(ring);
		 
		 return "redirect:/home";
	 }
	 
	 @RequestMapping("/fool_creator")
	 public String foolCreator(Model model, Principal principal) {
		 String username = principal.getName();
		 User user = userService.findByUsername(username);
		
//		 int days = Days.daysBetween(user.getCreatedAt(), new Date()).getDays();
		 
		 model.addAttribute("users", userService.getUsers());
		 model.addAttribute("teams", teamService.getTeams());
		 return "foolCreatorPage.jsp";
	 }
	 
	 @PostMapping("/create/team")
	 public String createTeam(@RequestParam("teamName") String teamName, @RequestParam("size") double size) {
		 Team team = new Team();
		 team.setName(teamName);
		 team.setSize(size);
		 teamService.create(team);
		 teamService.update(team);
		 
		 return "redirect:/fool_creator";
	 }
	 
	 @PostMapping("/join/team")
	 public String joinTeam(@RequestParam("team_id") long team_id, @RequestParam("user_id") long user_id) {
		 System.out.println(user_id);
		 System.out.println(team_id);
		 
		 User user = userService.getUser(user_id);
		 Team team = teamService.getTeam(team_id);
		 user.setTeam(team);
		 userService.updateUse(user);
		 
		 return "redirect:/fool_creator";
	 }
	 

	 @RequestMapping("/team/{id}")
	 public String showTeam(@PathVariable Long id, Model model) {
		 System.out.println(id);
		 model.addAttribute("team", teamService.getTeam(id));
		 model.addAttribute("users", userService.getUsers());
		 return "fellowshipDojo.jsp";
	 }
	
	 @RequestMapping("/delete/ring/{id}")
	 public String removeRing(@PathVariable Long id, Model model) {
		 Ring ring = ringService.getRing(id);
		 ringService.destroy(ring.getId());
		 return "redirect:/home";
	 }
}
