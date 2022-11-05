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

	@Value("${file.path}")
	String path;

	@RequestMapping(value = "testapi1", method = RequestMethod.GET)
	public ResponseEntity<?> testAPI(@RequestParam Map<String, String> requestParam) throws Exception {

		requestParam.put("Controller", "1");

		try {
			String operation = requestParam.get("operation");
			int v1 = Integer.parseInt(requestParam.get("a"));
			int v2 = Integer.parseInt(requestParam.get("b"));
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
			requestParam.put("Result", result + "");
			requestParam.put("Status", "Success");
		} catch (Exception e) {
			requestParam.put("Status", "Failure");
			requestParam.put("Error", e.toString());
		}
		return new ResponseEntity<>(requestParam, HttpStatus.OK);

	}

	@RequestMapping(value = "testapi2", method = RequestMethod.GET)
	public ResponseEntity<?> testAPI2(@RequestParam Map<String, String> requestParam) throws Exception {

		Properties properties = null;
		try {
			java.io.FileInputStream file = new FileInputStream(path);
			properties = new Properties();
			properties.load(file);
		} catch (Exception e) {
			System.out.println(e);
		}
		return new ResponseEntity<>(properties, HttpStatus.OK);

	}

}
