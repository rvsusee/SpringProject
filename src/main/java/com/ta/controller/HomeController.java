//package com.ta.controller;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import com.ta.model.User;
//import com.ta.repository.PersonRepository;
//
//@EnableJpaRepositories
//@Controller
//public class HomeController {
//
//	@Autowired
//	PersonRepository repo;
//
//	@PostMapping("/home")
//	public String submitForm(@ModelAttribute Model model) {
//		System.out.println("Home 1");
//
//		
//		return "home_page";
//	}
//
//	@GetMapping("/home")
//	public String loginForm(Model model) {
//		System.out.println("Home 2");
//		model .addAttribute("user", new User());
//		return "home_page";
//	}
//
//	
//	
//}
