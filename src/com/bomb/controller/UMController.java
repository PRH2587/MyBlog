package com.bomb.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bomb.dto.MessageView;

@Controller
@RequestMapping("/usermes")
public class UMController {
	
	private Logger logger = Logger.getLogger(getClass());
	
	@RequestMapping("/listm")
	public String listm(@ModelAttribute("mesview") MessageView mesview ,Model model){
		logger.info("Input [MessageView ]:-->"+mesview);
		
		
		return "";
	}
	
}
