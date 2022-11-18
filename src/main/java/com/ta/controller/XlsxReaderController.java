package com.ta.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/read/")
public class XlsxReaderController {

	@RequestMapping(value = "/xlsx")
	public String readFile() throws Exception{
		return "";
	}
	
}
