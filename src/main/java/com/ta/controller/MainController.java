package com.ta.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.origin.SystemEnvironmentOrigin;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ta.model.User;
import com.ta.repository.UserRepository;

@EnableJpaRepositories
@Controller
@RequestMapping("/index/")
public class MainController {

	@Autowired
	UserRepository repo;

	@GetMapping(value = "/list")
	public String getUsersList(Model model) throws Exception {

		List<User> users = new ArrayList<>();
		users.addAll(repo.findAll());
//		for (User user : users) {
//			System.out.println(user);
//		}
		model.addAttribute("usersList", users);

		return "UsersList";
	}

	@RequestMapping(value = "/newUser", method = RequestMethod.GET)
	public ResponseEntity<?> addNewUser(@RequestParam Map<String, String> inputs) throws Exception {
		try {
			User currUser = new User(inputs.get("email"), inputs.get("password"));
			int temp = repo.addNewUser(currUser);
			System.out.println(currUser);
			User currUserId = repo.findByID(currUser);
			if (currUser.getUserID() == 0) {
				inputs.put("Failed", "  ");
			} else {
				inputs.put("User Id: ", currUserId.getUserID() + "");
			}
		} catch (DuplicateKeyException e) {
			inputs.put("Failed", "Already You have an Account");
			System.out.println("User Already Found" + e);
		} catch (Exception e) {
			inputs.put("Failed", e+"");
			System.out.println("Exception Occured" + e);
		}
		return new ResponseEntity<>(inputs, HttpStatus.OK);
	}
}
