package com.astinel.pword.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.astinel.pword.service.TestService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/test/*")
@AllArgsConstructor
@Controller
public class TestController {
	private TestService service;
	
//	@GetMapping("/sum")
//	public void sum() {
//		log.info("sum========================");
//		String one = service.getOne();
//		String two = service.getTwo();
//		Integer sum = Integer.parseInt(one) + Integer.parseInt(two);
//		
//		log.info("(this is controller) ================:" + sum);
//	}
	
	@GetMapping("/sum")
	public void sum(Model model) {
		log.info("sum========================");
		String one = service.getOne();
		String two = service.getTwo();
		Integer sum = Integer.parseInt(one) + Integer.parseInt(two);
		
		log.info("(this is controller) ================:" + sum);
		
		model.addAttribute("sum", sum);
	}
}
