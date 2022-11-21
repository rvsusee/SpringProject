package com.ta.model;

public class Person {
	private int userId;
	private String name;
	private String age;
	private String gender;
	private String mobileNo;
	private String email;
	private String fatherName;
	private String motherName;
	private String homeLocation;
	private String jobType;
	private String salary;
	private String workLocation;
	private String education;

	public Person() {
	}

	public Person(String name, String age, String gender, String mobileNo, String email, String fatherName,
			String motherName, String homeLocation, String jobType, String salary, String workLocation,
			String education) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.mobileNo = mobileNo;
		this.email = email;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.homeLocation = homeLocation;
		this.jobType = jobType;
		this.salary = salary;
		this.workLocation = workLocation;
		this.education = education;
	}

	public Person(int userId, String name, String age, String gender, String mobileNo, String email, String fatherName,
			String motherName, String homeLocation, String jobType, String salary, String workLocation,
			String education) {
		this.userId = userId;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.mobileNo = mobileNo;
		this.email = email;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.homeLocation = homeLocation;
		this.jobType = jobType;
		this.salary = salary;
		this.workLocation = workLocation;
		this.education = education;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public String getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public String getEmail() {
		return email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public String getFatherName() {
		return fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public String getHomeLocation() {
		return homeLocation;
	}

	public String getJobType() {
		return jobType;
	}

	public String getSalary() {
		return salary;
	}

	public String getWorkLocation() {
		return workLocation;
	}

	public String getEducation() {
		return education;
	}
	@Override
	public String toString() {
		return "\n Full name: "+name
				+"\n Age: "+age
				+"\n Gender: "+gender
				+"\n Mobile Number: "+mobileNo
				+"\n E-mail:"+email
				+"\n Father Name: "+fatherName
				+"\n Mother Name: "+motherName
				+"\n Home Location: "+homeLocation
				+"\n Job Type: "+jobType
				+"\n Salary: "+salary
				+"\n Work Location: "+workLocation
				+"\n Education: "+education;
	}
}
