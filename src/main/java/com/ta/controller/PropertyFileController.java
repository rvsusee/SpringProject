package com.ta.controller;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Configuration
@RequestMapping("property")
public class PropertyFileController {

	@Autowired
	Environment env;


	@Value("${filepath}")
	String path;
	
	@GetMapping(value = "InternalFile")
	public ResponseEntity<?> readFile() throws Exception {

		List<String> list = new ArrayList<>();
		list.add(env.getProperty("name"));
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "ExternalFile", method = RequestMethod.GET)
	public ResponseEntity<?> testAPI2() {
		Properties properties = null;
		try {
			FileInputStream file = new FileInputStream(path);
			properties = new Properties();
			properties.load(file);
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("testAPI Ended");
		
		return new ResponseEntity<>(properties, HttpStatus.OK);
	}
}
