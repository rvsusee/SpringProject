package com.ta.controller;

import java.io.FileInputStream;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Properties;

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

	@RequestMapping(value = "testapi1", method = RequestMethod.GET)
	public ResponseEntity<?> testAPI(@RequestParam Map<String, String> inputs) throws Exception {

		try {
			String operation = inputs.get("operation");
			int v1 = Integer.parseInt(inputs.get("a"));
			int v2 = Integer.parseInt(inputs.get("b"));
			int result = 0;

			if ("add".equals(operation)) {
				result = calc.add(v1, v2);
			} else if ("sub".equals(operation)) {
				result = calc.sub(v1, v2);
			} else if ("mul".equals(operation)) {
				result = calc.mul(v1, v2);
			} else if ("div".equals(operation)) {
				result = calc.div(v1, v2);
			} else {
				throw new InputMismatchException("Invalid Operation");
			}
			
			
			inputs.put("Result", result + "");
			inputs.put("Status", "Success");
		} catch (Exception e) {
			inputs.put("Status", "Failure");
			inputs.put("Error", e.toString());
		}
		
		
		return new ResponseEntity<>(inputs, HttpStatus.OK);

	}

	
	@RequestMapping(value = "testapi2", method = RequestMethod.GET)
	public ResponseEntity<?> testAPI2() {

		Properties properties = null;
		try {
			FileInputStream file = new FileInputStream(path);
			properties = new Properties();
			properties.load(file);
		} catch (Exception e) {
			System.out.println(e);
		}
		return new ResponseEntity<>(properties, HttpStatus.OK);

	}

}
