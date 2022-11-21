package com.ta.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ta.model.Person;
import com.ta.model.User;
import com.ta.repository.UserRepository;

@EnableJpaRepositories
@Controller
public class MainController {

	@Autowired
	UserRepository repo;

	@GetMapping(value = "/users_list")
	public String getUsersList(Model model) throws Exception {

		List<User> users = new ArrayList<>();
		users.addAll(repo.findAll());
		model.addAttribute("usersList", users);
		return "users_list";
	}

	@RequestMapping(value = "/newUser", method = RequestMethod.GET)
	public ResponseEntity<?> addNewUser(@RequestParam Map<String, String> inputs) throws Exception {
		User currUser = new User(inputs.get("email"), inputs.get("password"));
		try {
			int temp = repo.addNewUser(currUser);
			System.out.println(currUser);
			currUser = repo.findByID(currUser);
			if (currUser.getUserID() != 0) {
				inputs.put("User Id: ", currUser.getUserID() + "");
			} else {
				inputs.put("Failed", "Unable to Create Account");
			}
		} catch (DuplicateKeyException e) {
			inputs.put("Failed", "User Already You have an Account");
			System.out.println("User Id is :" + repo.findByID(currUser));
		} catch (Exception e) {
			inputs.put("Failed", e + "");
			System.out.println("Exception Occured" + e);
		}
		return new ResponseEntity<>(inputs, HttpStatus.OK);
	}

	@GetMapping("/register")
	public String registerForm(Model model) {

		Person person = new Person();
		model.addAttribute("person", person);

		return "register_form";
	}

	@PostMapping("/register")
	public String submitForm(@ModelAttribute("person") Person person) {
		System.out.println(person);
		return "register_success";
	}

	@GetMapping("/login")
	public String loginForm(Model model) {
		model.addAttribute("user", new User());
		return "login_form";
	}

	@PostMapping("/login")
	public String loginForm(@ModelAttribute User user, Model model) {
		System.out.println("USerrr"+user);
		User currUser = repo.findByID(user);
		if(repo.isValidUser(user,currUser)) {
			model.addAttribute("userName",repo.getNameByID(currUser.getUserID()));
		    System.out.println("Current User Name: "+model.getAttribute("userName"));
			return "home_page";
		}
		return "login_form";
	}
}
