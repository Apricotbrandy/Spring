package com.astinel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.astinel.service.TestService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/test/")
@AllArgsConstructor
@Controller
public class TestController {
	private TestService service;
	
	@GetMapping("/getOnePlusTwo")
	public void getOnePlusTwo(Model model) {
//	public void getOnePlusTwo() {
		log.info("getOnePlusTwo ==========================================");
		String one = service.getOne();
		String two = service.getTwo();
		Integer sum = Integer.parseInt(one) + Integer.parseInt(two); 
		
		log.info("(here is controller) 1 plus 2 is ====================:" + sum);
		
		model.addAttribute("sum",sum);
	}
}
