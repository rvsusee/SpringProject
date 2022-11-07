package com.ta.service;

import java.util.Properties;

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
	Properties p = new Properties();
	
	@Override
	public String toString() {
		return "username: "+username+", password: "+password;
	}

	public boolean checkUserPass(String useraname, String password) {
		return this.username.equals(useraname)&&this.password.equals(password) ? true : false;
	}
		
}
