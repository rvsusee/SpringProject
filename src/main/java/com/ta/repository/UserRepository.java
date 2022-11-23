package com.ta.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Repository;

import com.ta.model.Person;
import com.ta.model.User;


@Configurable
@Repository
public interface UserRepository {
	String addNewUser(User user,Person person);

	int updateUser(User user);

	User findByID(User user);

	int deleteById(int id);

	List<User> findAll();

	boolean isValidUser(User user,User currUser);

	String getNameByID(int userId);
	
	
}
