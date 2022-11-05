package com.ta.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inputs/")
public class HtmlController {

	@RequestMapping(value = "view", method = RequestMethod.GET)
	public ResponseEntity<?> display(@RequestParam Map<String, String> input) throws Exception {		
		return new ResponseEntity<>(input,HttpStatus.OK);
	}

}
