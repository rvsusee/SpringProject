package com.ta.controller;

import java.io.FileInputStream;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ta.service.Operations;
import com.ta.service.PropertyFile;

@RestController
@RequestMapping("/test/")
public class TestController {

	@Autowired
	Operations calc;
	PropertyFile file;

	@Value("${filepath}")
	String path;

	Logger log = org.apache.logging.log4j.LogManager.getLogger("TestController");

	@RequestMapping(value = "inputs", method = RequestMethod.GET)
	public ResponseEntity<?> testAPI(@RequestParam Map<String, String> inputs) throws Exception {
		System.out.println("input service");
		log.info("inputs service started: ");
		log.trace("inputs controller started");
		log.debug("testAPI started: " + inputs);
		try {
			String operation = inputs.get("operation");
			log.warn("Input type casting ");
			int v1 = Integer.parseInt(inputs.get("a"));
			int v2 = Integer.parseInt(inputs.get("b"));
			log.debug("Values: a - " + v1 + " and b - " + v2);
			inputs.put("Status", "Success");
			throw new InputMismatchException("Invalid Operation");
		} catch (Exception e) {
			log.error("An ERROR Message");
			inputs.put("Status", "Failure");
			inputs.put("Error", e.toString());
		}

		log.info("Input Values: " + inputs);
		log.debug("inputs controller  ended: " + inputs);
		log.trace("inputs controller ended");
		System.out.println("testAPI Ended");
		return new ResponseEntity<>(inputs, HttpStatus.OK);
	}

	@RequestMapping(value = "readFile", method = RequestMethod.GET)
	public ResponseEntity<?> testAPI2() {
		log.trace("inputs controller started");
		log.info("inputs controller started");
		Properties properties = null;
		try {
			FileInputStream file = new FileInputStream(path);
			properties = new Properties();
			properties.load(file);
			log.info("properties Values : "+properties);
		} catch (Exception e) {
			log.error("An ERROR Message: "+e);
			System.out.println(e);
		}
		log.info("Input Values: " + properties);
		log.debug("inputs controller ended: " + properties);
		log.trace("inputs controller ended");
		System.out.println("testAPI Ended");
		
		return new ResponseEntity<>(properties, HttpStatus.OK);

	}

}
