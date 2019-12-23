package com.co.domain.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//import com.co.domain.service.TodoService;

@Controller
@RequestMapping("test")
public class HelloController {
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
//
//	@Inject
//	TodoService todoService;
//	
	
	@GetMapping(value = "/thuan")
//	@ResponseBody
	public String home(Model model) {
		System.out.println("Aaaaa");
		logger.info("Welcome home!!!!!!!!!");
		model.addAttribute("name", "Thuan Envity!!!!!!!");
		return "welcome/home";
	}

}
