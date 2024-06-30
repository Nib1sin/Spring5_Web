package com.efsoft.spring_mvc.model;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@ModelAttribute
	public void modelData(Model m){
		m.addAttribute("name", "Aliens");
	}
	
	@RequestMapping("/")
	public String home(){
		return "index";
	}
	
	@RequestMapping("addAlien")
	public String addAlien(@ModelAttribute("alien") Alien a) {
		return "result";
	}
	

}
