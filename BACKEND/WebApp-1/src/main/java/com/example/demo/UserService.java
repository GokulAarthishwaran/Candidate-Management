package com.example.demo;

import java.util.List;
import java.util.Map;
import java.lang.Number;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
	
	@Autowired
	private DatabaseService ds;
	
	
	public void createUser(User user)
	{
		ds.CreateUser(user);
	}
	
	public User viewUser(int id,int vid)
	{
		return ds.ViewUser(id,vid);
	}
	
	public List<User> deleteUser(int id)
	{
		ds.DeleteUser(id);
		return (List<User>) ds.UserAll();
	}
	
	public List<User> searchUser(String firstName)
	{
		return ds.SearchUser(firstName);
	}
	
	public void updateUser(User user)
	{
		ds.UpdateUser(user);
	}
	
	public List<User> userAll()
	{
		return (List<User>) ds.UserAll();
	}
	
	public List<Location> locationWiseCount()
	{
		return  ds.LocationWiseCount();
	}
	
	public List<Location> skillWiseCount()
	{
		return  ds.SkillWiseCount();
	}
	
	public List<Location> roleWiseCount()
	{
		return  ds.RoleWiseCount();
	}
	
	public List<Location> yearWiseCount()
	{
		return  ds.YearWiseCount();
	}
	
	
	
//	public Map<String,Integer> locationWiseCount()
//	{
//		return  ds.LocationWiseCount();
//	}
//	
//	public Map<String,Integer> skillWiseCount()
//	{
//		return  ds.SkillWiseCount();
//	}
	

}
