package com.covid19.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.covid19.service.CoronaService;

@Controller
public class CoronaController {
	
	@Autowired
	CoronaService service;
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("locationstates", service.getAllStats());
		return "Home";
	}
	
	

}
