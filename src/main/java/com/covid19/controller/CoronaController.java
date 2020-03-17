package com.covid19.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.covid19.model.LocationStats;
import com.covid19.service.CoronaService;

@Controller
public class CoronaController {
	
	@Autowired
	CoronaService service;
	
	@GetMapping("/")
	public String home(Model model) {
		List<LocationStats> allStats = service.getAllStats();
		int totalReportedCases = allStats.stream().mapToInt(stat -> stat.getConfirmedCases()).sum();
		model.addAttribute("locationstates", allStats);
		model.addAttribute("totalReportedCases", totalReportedCases);
		return "Home";
	}
	
	

}
