package com.example.demo;

import org.springframework.data.annotation.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int vid;
	private String firstName;
	private String lastName;
	private String email;
	private String role;
	private String location;
	private String contact;
	private String dob;
	private String doj;
	private String fatherName;
	private String motherName;
	private String address;
	private String collegeName;
	private String dept;
	private String skill;
	private int yearOfPassedOut;
	private String updatedUser;
	private String createTime;
	private String updateTime;
	
	public User()
	{
		
	}

	public User(int id, int vid, String firstName, String lastName, String email, String role, String location,
			String contact, String dob, String doj, String fatherName, String motherName, String address,
			String collegeName, String dept, String skill, int yearOfPassedOut, String updatedUser, String createTime,
			String updateTime) {
		super();
		this.id = id;
		this.vid = vid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
		this.location = location;
		this.contact = contact;
		this.dob = dob;
		this.doj = doj;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.address = address;
		this.collegeName = collegeName;
		this.dept = dept;
		this.skill = skill;
		this.yearOfPassedOut = yearOfPassedOut;
		this.updatedUser = updatedUser;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public int getYearOfPassedOut() {
		return yearOfPassedOut;
	}

	public void setYearOfPassedOut(int yearOfPassedOut) {
		this.yearOfPassedOut = yearOfPassedOut;
	}

	public String getUpdatedUser() {
		return updatedUser;
	}

	public void setUpdatedUser(String updatedUser) {
		this.updatedUser = updatedUser;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", vid=" + vid + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", role=" + role + ", location=" + location + ", contact=" + contact + ", dob=" + dob
				+ ", doj=" + doj + ", fatherName=" + fatherName + ", motherName=" + motherName + ", address=" + address
				+ ", collegeName=" + collegeName + ", dept=" + dept + ", skill=" + skill + ", yearOfPassedOut="
				+ yearOfPassedOut + ", updatedUser=" + updatedUser + ", createTime=" + createTime + ", updateTime="
				+ updateTime + "]";
	}

	

	
	
}
