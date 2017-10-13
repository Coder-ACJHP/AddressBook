package com.coder.addressBook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

	@GetMapping("/404")
	public String pageNotFound(Model model) {
		model.addAttribute("headError", "404");
		model.addAttribute("errorBody", "The requested Url was not found on this server!");
		return "error";
	}
	
	@GetMapping("/500")
	public String handleInternalErrors(Model model) {
		model.addAttribute("headError", "500");
		model.addAttribute("errorBody", "Your connection refused, this may coused from internal server or fimilar things!");
		return "error";
	}
}
