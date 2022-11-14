package com.ta.controller;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ta.service.User;

import repository.UserRepository;

@RestController
@RequestMapping("/users/")
public class UserController implements CommandLineRunner {

	@Autowired
	User user;

	@Autowired
	UserRepository userRepository;

	@Autowired
	JdbcTemplate jdbcTemplate;

	Logger log = LogManager.getLogger("UserController");

	@GetMapping("/getUsers")
	public String getUsers(Model model) throws Exception {
		List<com.ta.model.User> users = userRepository.findAll();
		model.addAttribute("ListCustomers", users);
		return "";
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String loginUser(@RequestParam Map<String, String> input) throws Exception {
		log.info("Login Service started: " + input);

		if (user.checkUserPass(input.get("name"), input.get("pass"))) {
			log.debug("Checking : " + "Login Success");
			log.info("Login Service Ended: " + "Login Success");
			return "Login Success";
		}

		log.debug("Login Failed: " + input);
		log.info("Login Service Ended: " + input);
		return "Login Failed";

	}

	@GetMapping(value = "getusers")
	public String getUsers() throws Exception {
		log.info("getusers Service started ");
		log.debug("getusers service started: ");
		String userValue = user.toString();

		log.debug("getusers service Values: " + userValue);

		log.debug("getusers service Ended: ");
		return userValue;
	}

	@Override
	public void run(String... args) throws Exception {
		String sql = "SELECT * FROM SUSEENDHIRAN_MATRIMONY_USERS";
		List<User> users = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(User.class));
		List<com.ta.model.User> userss = userRepository.findAll();

		users.forEach(System.out::println);
		System.out.println("------------------------------------");
		userss.forEach(System.out::println);

	}
}
