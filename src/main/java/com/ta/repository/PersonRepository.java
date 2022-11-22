package com.ta.repository;

import java.util.List;

import com.ta.model.Person;

public interface PersonRepository {

	List<Person> getAllPersons(Person userDetails);

	Person getPerson(int userID);
	
}
