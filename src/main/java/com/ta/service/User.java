package com.ta.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service

@PropertySource("classpath:users.properties")
public class User {
	
	@Value("${name}")
	private String username;
	
	@Value("${pass}")
	private String password;
	
	@Override
	public String toString() {
		return "username: "+username+", password: "+password;
	}

	public boolean checkUserPass(String string, String string2) {
		
		return false;
	}
		
}
