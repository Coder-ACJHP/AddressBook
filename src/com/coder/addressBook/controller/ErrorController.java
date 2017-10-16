package com.coder.addressBook.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

	//Specific for handling JTA creation error
	@ExceptionHandler(CannotCreateTransactionException.class)
	public String handleConnectionError(Model model, CannotCreateTransactionException ex) {
		model.addAttribute("headError", "500");
		model.addAttribute("errorBody", "This error may coused from JTA creation or internet connection!");
		return "error";
	}

	
	//Generally handling all errors and 500 is also included even it was handled with specific method
	@GetMapping("error")
	public String handleErrors(Model model, HttpServletRequest request) {
		
		String httpErrorHead = "";
		String httpErrorMessage = "";
		int errorCode = getErrorCode(request);
		
		switch (errorCode) {
		case 400:
			httpErrorHead = "400";
			httpErrorMessage = "Bad request!";
			break;
		case 401:
			httpErrorHead = "401";
			httpErrorMessage = "Unathorized request!";
			break;
		case 404:
			httpErrorHead = "404";
			httpErrorMessage = "Resource not found on this server!";
			break;
		case 500:
			httpErrorHead = "500";
			httpErrorMessage = "Internal server error!";
			break;	
		default:
			break;
		}
		
		model.addAttribute("headError", httpErrorHead);
		model.addAttribute("errorBody", httpErrorMessage);
		
		return "error";
	}
	
	private int getErrorCode(HttpServletRequest request) {
		return (int) request.getAttribute("javax.servlet.error.status_code");
	}
}
