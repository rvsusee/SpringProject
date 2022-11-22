package com.ta.model;

public class Person {
	private int userID;
	private String name;
	private String age;
	private String gender;
	private String mobileNo;
	private String fatherName;
	private String motherName;
	private String homeLocation;
	private String jobType;
	private String salary;
	private String workLocation;
	private String education;

	public Person() {
	}

	public Person(int userID, String name, String age, String gender, String mobileNo, String fatherName,
			String motherName, String homeLocation, String jobType, String salary, String workLocation,
			String education) {
		this.userID = userID;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.mobileNo = mobileNo;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.homeLocation = homeLocation;
		this.jobType = jobType;
		this.salary = salary;
		this.workLocation = workLocation;
		this.education = education;
	}

	@Override
	public String toString() {
		return "\n userID:" + userID + " \n Name: " + name + "\n Age: " + age + "\n Gender: " + gender
				+ "\n Mobile Number: " + mobileNo + "\n Father Name: " + fatherName + "\n Mother Name: " + motherName
				+ "\n Home Location: " + homeLocation + "\n Job Type: " + jobType + "\n Salary: " + salary
				+ "\n Work Location: " + workLocation + "\n Education: " + education;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getHomeLocation() {
		return homeLocation;
	}

	public void setHomeLocation(String homeLocation) {
		this.homeLocation = homeLocation;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getWorkLocation() {
		return workLocation;
	}

	public void setWorkLocation(String workLocation) {
		this.workLocation = workLocation;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

}
