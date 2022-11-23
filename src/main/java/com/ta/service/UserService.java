package com.ta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.ta.model.Person;
import com.ta.model.User;
import com.ta.repository.UserRepository;

@Service
public class UserService implements UserRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public String addNewUser(User user, Person person) {
		try {
			String sqlUser = "INSERT INTO SUSEENDHIRAN_MATRIMONY_USERS(email,password) VALUES (?,?)";
			jdbcTemplate.update(sqlUser, new Object[] { user.getEmail(), user.getPassword() });
			int currUserID = findByID(user).getUserID();
			user.setUserID(currUserID);
			person.setUserID(currUserID);
			try {
				String sqlPerson = "INSERT INTO SUSEENDHIRAN_MATRIMONY_USER_DETAILS(userID,name,age,gender,mobileNo,fatherName,motherName,homeLocation,jobType,salary,workLocation,education) "
						+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
				jdbcTemplate.update(sqlPerson,
						new Object[] { person.getUserID(), person.getName(), person.getAge(), person.getGender(),
								person.getMobileNo(), person.getFatherName(), person.getMotherName(),
								person.getHomeLocation(), person.getJobType(), person.getSalary(),
								person.getWorkLocation(), person.getEducation() });
				return "SUCCESS";
			} catch (Exception e) {
				System.out.println(e);
				return "UAPD";
			}
		} catch (DataAccessException e) {
			System.out.println("Unable to Add");
			return "UAUD";
		}
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
	public boolean isValidUser(User user, User currUser) {
		if (user.getEmail().equals(currUser.getEmail())) {
			if (user.getPassword().equals(currUser.getPassword())) {
				System.out.println("Login Success");
				return true;
			} else {
				System.out.println("Password Wrong");
				return false;
			}
		} else {
			System.out.println("Email and Password");
		}
		return false;
	}

	public String getNameByID(int userId) {
		String sql = "SELECT name FROM SUSEENDHIRAN_MATRIMONY_USER_DETAILS WHERE userID=" + userId;
		try {
			return jdbcTemplate.queryForObject(sql, String.class);
		} catch (EmptyResultDataAccessException e) {
			return "User";
		}
	}
}
