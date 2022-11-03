package com.ta.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PropertyFile{
	
	public void writeFile(Map<String, String> map) {
		try {
			File file = new ClassPathResource("src/main/resourcesfile.properties").getFile();
			FileWriter writer = new FileWriter(file);
			Properties properties = new Properties();

			for (String key : map.keySet()) {
				properties.setProperty(key.toString(), map.get(key).toString());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ResponseEntity<?> readFile() throws IOException {
		File file = new ClassPathResource("src/main/resourcesfile.properties").getFile();		
		FileInputStream inputStream = new FileInputStream(file);
		Properties properties = new Properties();
		properties.load(inputStream);

		List<String> list = new ArrayList<>();
		for (Object key : properties.keySet()) {
			list.add(key.toString());
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}