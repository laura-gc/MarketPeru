package com.init.Markertper.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Controller
public class LoginController {

	@GetMapping({"/","/login"})
	public String index() {
		return "Login";  
	}
	
	@GetMapping("/inicio")
	public String menu() {
		return "Inicio";
	}
	 
	 @RequestMapping("/accessdenied")
	    public String accessdenied(Model model) {
	        return "Inicio"; 
	    }
	
}
