package com.efsoft.spring_mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.efsoft.spring_mvc.model.Alien;
import com.efsoft.spring_mvc.repository.AlienRepository;

@Controller
public class AlienController {

	@Autowired
	AlienRepository alienRepository;
	
	//Para devolver un xml y no un json
	//@GetMapping(path="aliens", produces={"aplication/xml"})
	@GetMapping("aliens")
	public List<Alien> getAliens(){
		//m.addAttribute("result", alienRepository.getAliens()); 
		List<Alien> aliens = alienRepository.getAliens();
		return aliens;
	}
	
	@GetMapping("alien/{aid}")
	public Alien getAlien(@PathVariable("aid") int aid){
		Alien alien = alienRepository.getAlien(aid);
		return alien;
	}

	//@PostMapping(path="alien", consumes={MediaType.APPLICATION_JSON_VALUE}
	@PostMapping(path="alien", consumes={"application/json"})
	public Alien addAlien(@RequestBody Alien alien){
		alienRepository.addAlien(alien);
		return alien;
	}

}
