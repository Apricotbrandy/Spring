package com.astinel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.astinel.service.TestService;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/test/*")
@AllArgsConstructor
@Controller
public class TestController {
	
	@Setter(onMethod_ = @Autowired)
	private TestService service;
	
	@GetMapping("/getOnePlusTwo")
	public void getOnePlusTwo(Model model) {
//	public void getOnePlusTwo() {
		log.info("getOnePlusTwo====================================");
		String one = service.getOne();
		String two = service.getTwo();
		Integer sum = Integer.parseInt(one)+Integer.parseInt(two);
		
		log.info("(This is controller) 1 plus 2 is ================:"+sum);
		
		model.addAttribute("sum",sum);
	}
	
	/* answer 1*/
	@GetMapping("/updateVisitantCount")
	public void updateVisitantCount() {
		log.info("=================================: running updateVisitantCount() on controller");
		service.updateVisitantCount();
		log.info("(This is controller) update success");
	}
	
	/* answer 2*/
	@GetMapping("/insertDoodle")
	public void insertDoodle() {
		log.info("=================================: running insertDoodle() on controller");
		service.insertDoodle();
		log.info("(This is controller) insert success");
	}
	
	/* answer 3*/
	@GetMapping("/delTest")
	public void delTest() {
		log.info("=================================: running delTest() on controller");
		service.delTest();
		log.info("(This is controller) delete success");
	}
	
}
