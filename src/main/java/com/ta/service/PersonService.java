package com.ta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.ta.model.Person;
import com.ta.model.User;
import com.ta.repository.PersonRepository;

@Service
public class PersonService implements PersonRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Person> getAllPersons(Person userDetails) {
		return jdbcTemplate.query("SELECT * from SUSEENDHIRAN_MATRIMONY_USER_DETAILS WHERE userID <> ? AND gender <> ?",
				BeanPropertyRowMapper.newInstance(Person.class), userDetails.getUserID(), userDetails.getGender());
	}

	@Override
	public Person getPerson(int userID) {
		try {
			Person person = jdbcTemplate.queryForObject(
					"SELECT * FROM SUSEENDHIRAN_MATRIMONY_USER_DETAILS WHERE userID = ?",
					BeanPropertyRowMapper.newInstance(Person.class), userID);
			return person;
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Something wrong");
		}
		return null;
	}

}
