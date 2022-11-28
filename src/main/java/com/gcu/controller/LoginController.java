package com.gcu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.LoginBusinessService;
import com.gcu.business.ProductsBusinessService;
import com.gcu.business.ProductsBusinessServiceInterface;
import com.gcu.model.LoginModel;
import com.gcu.model.OrderModel;
import com.gcu.model.ProductsModel;
import com.gcu.model.RegisterModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/login")
public class LoginController 
{
	Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	public ProductsBusinessServiceInterface productService;
	@Autowired
	public LoginBusinessService loginService;
	
	@GetMapping("/")
	public String display(Model model)
	{
		logger.info("Entering LoginController.display()");
		// Display login form view 
		model.addAttribute("title", "Now it is time to Login!");
		model.addAttribute("loginModel", new LoginModel());
		return "login";
	}
	
	@PostMapping("/doLogin")
	public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model)
	{	
		logger.info("Entering LoginController.doLogin()");
		// Check for validation errors
		if (bindingResult.hasErrors())
		{
			model.addAttribute("title", "Login Form");
			return "login";
		}
		
		if (loginService.checkLogin(loginModel.getUsername(), loginModel.getPassword())) 
		{
			model.addAttribute("title", "Login Success! Welcome in!");
			return "loginSuccess";
		}
		else 
		{
			model.addAttribute("title", "Login Failed! Now leave!");
			return "loginFailed";	
		}
	}
	
	@GetMapping("/products")
	public String productsPage(Model model)
	{
		logger.info("Entering LoginController.profuctsPage()");
		model.addAttribute("title", "Now enter in the product that you want to add!");
		model.addAttribute("productsModel", new ProductsModel());
		return "products";
	}	
	
	@GetMapping("/reviews")
	public String reviewsPage(Model model)
	{
		logger.info("Entering LoginController.reviews()");
		model.addAttribute("title", "This is where the reviews will be!");
		return "reviews";
	}
	
	@GetMapping("/doRegister")
	public String registrationPage(Model model)
	{
		logger.info("Entering LoginController.registrationPage()");
		// Display the register page
		model.addAttribute("title", "Are you truly ready to register?");
		model.addAttribute("registerModel", new RegisterModel());
		return "register";
	}
	
	@PostMapping("/registerSuccess")
	public String successfulRegister(Model model)
	{	
		logger.info("Entering LoginController.successfulRegister()");
		model.addAttribute("title", "You have successfully registered!");
		return "registerSuccess";
	}
	
	@PostMapping("/personalProductPage")
	public String personalProductPage(@Valid ProductsModel productsModel, BindingResult bindingResult, Model model)
	{	
		logger.info("Entering LoginController.personalProductPage()");
		if (bindingResult.hasErrors())
		{
			return "products";
		}
		
		productService.addProduct(productsModel);
		model.addAttribute("title", "You have successfully seen your products!");
		model.addAttribute("productService", productService);
		
		return "personalProductPage";
	}
}
