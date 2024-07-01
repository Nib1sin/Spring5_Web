package com.efsoft.spring_mvc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.efsoft.spring_mvc.model.Alien;
import com.efsoft.spring_mvc.repository.AlienRepository;

import java.util.List;

@Controller
public class HomeController {

	@Autowired
	private AlienRepository alienRepository;
	
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
	
	@RequestMapping("getAliens")
	public String getAliens(Model m){
		//List<Alien> aliens = Arrays.asList(new Alien(101, "Holis"), new Alien(102, "Holis2"));
		m.addAttribute("result", alienRepository.getAliens()); 
		
		return "showAliens";
	}

}
