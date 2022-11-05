package com.ta.controller;

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
@RequestMapping("/test/")
public class TestController {

	@Autowired
	Operations calc;
	PropertyFile file;
	
	
	@RequestMapping(value = "testapi", method = RequestMethod.GET)
	public ResponseEntity<?> testAPI(@RequestParam Map<String, String> requestParam) throws Exception {

		String operation = requestParam.get("operation");
		

		int v1 = Integer.parseInt(requestParam.get("a"));		
		int v2= Integer.parseInt(requestParam.get("b"));
		int result = 0;
		
		if ("add".equals(operation)) {
			result = calc.add(v1, v2);
		} else if ("sub".equals(operation)) {
			result = calc.sub(v1, v2);		
		} else if ("mul".equals(operation)) {
			result = calc.mul(v1, v2);
		} else if ("div".equals(operation)) {
			result = calc.div(v1, v2);
			
			
		}

		requestParam.put("Result", result+"");		

//		file.writeFile(requestParam);
//		return file.readFile();

		
//		String res;
//
//		res = "<center><table border= '2'><center>";
//		for (String key : requestParam.keySet()) {
//			res += "<tr><td>"+key+"</td><td>"+requestParam.get(key).toString()+"</td></tr>";
//		}
//		res += "</table>";
		
		return new ResponseEntity<> (requestParam , HttpStatus.OK);

	}

}
