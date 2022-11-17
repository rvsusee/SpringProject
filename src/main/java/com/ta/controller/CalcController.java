package com.ta.controller;

import java.util.InputMismatchException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ta.service.Operations;
import com.ta.service.PropertyFile;

@RestController
@RequestMapping("/calc/")
public class CalcController {

	@Autowired
	Operations calc;
	PropertyFile file;

	@RequestMapping(value = "inputs", method = RequestMethod.GET)
	public ResponseEntity<?> testAPI(@RequestParam Map<String, String> inputs) throws Exception {
		System.out.println("input service");
		try {
			String operation = inputs.get("operation");
			int v1 = Integer.parseInt(inputs.get("a"));
			int v2 = Integer.parseInt(inputs.get("b"));
			inputs.put("Status", "Success");
			throw new InputMismatchException("Invalid Operation");
		} catch (Exception e) {
			inputs.put("Status", "Failure");
			inputs.put("Error", e.toString());
		}

		System.out.println("Calc Ended");
		return new ResponseEntity<>(inputs, HttpStatus.OK);
	}

}
