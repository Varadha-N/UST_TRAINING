package com.ust.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ust.flightreservation.entities.User;
import com.ust.flightreservation.repos.UserRepository;

@Controller
public class UserController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/showReg")
	public String showRegistrationPage() {
		
		LOGGER.info("In registation page");
		
		return "login/registerUser";
	}
	
	@RequestMapping(value = "/registerUser", method= RequestMethod.POST)
	public String register(@ModelAttribute("user") User user) {
		userRepository.save(user);
		
		LOGGER.info("Saved user ="+user);
		return "login/login";
	}
	
	@RequestMapping("/showLogin")
	public String showLoginPage() {
		
		LOGGER.info("In Login page");
		
		return "login/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(
			@RequestParam("email") String email, 
			@RequestParam("password") String password, 
			ModelMap modelMap) {
		
		User user = userRepository.findByEmail(email);
		if(user.getPassword().equals(password)) {
		
			LOGGER.info("In user login success"+user);
			return "findFlights";
		} else {
			
			LOGGER.info("Login failed");
			modelMap.addAttribute("msg", "Invalid user name or password. Please try again");
		}
		
		return "login/login";
	}
	
}









