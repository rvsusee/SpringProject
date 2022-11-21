package com.ta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.ta.model.User;
import com.ta.repository.UserRepository;

@Service
public class JdbcUserRepository implements UserRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int addNewUser(User user) {
		String sql = "INSERT INTO SUSEENDHIRAN_MATRIMONY_USERS(email,password) VALUES (?,?)";
		return jdbcTemplate.update(sql, new Object[] { user.getEmail(), user.getPassword() });
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User findByID(User user) {
		try {
			User currUser = jdbcTemplate.queryForObject("SELECT * FROM SUSEENDHIRAN_MATRIMONY_USERS WHERE email=?",
					BeanPropertyRowMapper.newInstance(User.class), user.getEmail());
			System.out.println("Find User By ID: "+currUser);
			return currUser;
		} catch (Exception e) {
			System.out.println("Something wrong");
		}
		return user;
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> findAll() {
		return jdbcTemplate.query("SELECT * from SUSEENDHIRAN_MATRIMONY_USERS",
				BeanPropertyRowMapper.newInstance(User.class));
	}

	@Override
	public boolean isValidUser(User user,User currUser) {
		if(user.getEmail().equals(currUser.getEmail())) {
			if(user.getPassword().equals(currUser.getPassword())) {
				System.out.println("Login Success");
				return true;
			}else {
				System.out.println("Password Wrong");
				return false;
			}
		}else {
			System.out.println("Email and Password");
		}
		return false;
	}
	
	public String getNameByID(int userId){
	    String sql = "SELECT name FROM SUSEENDHIRAN_MATRIMONY_USER_DETAILS WHERE userID="+userId;	    
	    return (String) jdbcTemplate.queryForObject(sql, String.class);
	
	}
	


}
