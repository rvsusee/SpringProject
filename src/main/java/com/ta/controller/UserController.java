package com.ta.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ta.service.User;

@RestController
@RequestMapping("/users/")
public class UserController {

	@Autowired
	User user;

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String loginUser(@RequestParam Map<String, String> input) throws Exception {
		if (user.checkUserPass(input.get("name"), input.get("pass"))) {
			return "Login Success";
		}
		return "Login Failed";
	}

	@GetMapping(value = "getusers")
	public String getUsers() throws Exception {
		return user.toString();
	}

}
