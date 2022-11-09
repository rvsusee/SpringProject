package com.ta.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Configuration
@RequestMapping("read")
public class PropertyFileController {

	@Autowired
	Environment env;

	@GetMapping(value = "file")
	public ResponseEntity<?> readFile() throws Exception {

		List<String> list = new ArrayList<>();
		list.add(env.getProperty("a"));
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
