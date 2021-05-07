package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Long;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;  
import org.springframework.jdbc.core.RowMapper;

@Component
public class DatabaseService {

	@Autowired
	private JdbcTemplate jd;
	static int pid=0;  
	
	public DatabaseService()
	{
	}
	
	public void CreateUser(User user)
    {
		this.pid = this.jd.queryForObject("select max(id) from candidate",Integer.class);
		this.pid=this.pid+1;
		
		String fname="C:\\Users\\gokul\\Documents\\candidatemanagement\\userlogs.txt";
		String s = "ID-" + this.pid + " : user "+user.getFirstName() +" is Created with id : " + this.pid + " and vid : 1 at " + user.getCreateTime() +" \n"; 
		Logging(fname, s); 
	    
		//System.out.println("User is created with id as " +this.pid +" and user details are ");

		this.jd.update("insert into candidate(id,firstname,lastname,email,role,location,contact,dob,doj,fathername,mothername,address,collegename,dept,skill,yearofpassedout,createtime) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",this.pid, user.getFirstName(),user.getLastName(),user.getEmail(),user.getRole(),user.getLocation(),user.getContact(),user.getDob(),user.getDoj(),user.getFatherName(),user.getMotherName(),user.getAddress(),user.getCollegeName(),user.getDept(),user.getSkill(),user.getYearOfPassedOut(),user.getCreateTime());
		//System.out.println(user);
    }
    
    @SuppressWarnings("deprecation")
	public User ViewUser(int id,int vid)
    {
    	//System.out.println("User is viewed with id : " +id+ " and vid : " + vid);
    	return (User)this.jd.queryForObject("select * from candidate where id = ? and vid = ?",new Object[]{id,vid},
    	        new RowMapper<User>() 
    	        {
    	            public User mapRow(ResultSet rs, int rowNum) throws SQLException 
    	            {
    	            	User user = new User();
		                user.setId(rs.getInt("id"));
		                user.setVid(rs.getInt("vid"));
		                user.setFirstName(rs.getString("firstname"));
		                user.setLastName(rs.getString("lastname"));
		                user.setEmail(rs.getString("email"));
		                user.setRole(rs.getString("role"));
		                user.setLocation(rs.getString("location"));
		                user.setContact(rs.getString("contact"));
		                user.setDob(rs.getString("dob"));
		                user.setDoj(rs.getString("doj"));
		                user.setFatherName(rs.getString("fathername"));
		                user.setMotherName(rs.getString("mothername"));
		                user.setAddress(rs.getString("address"));
		                user.setCollegeName(rs.getString("collegename"));
		                user.setDept(rs.getString("dept"));
		                user.setSkill(rs.getString("skill"));
		                user.setYearOfPassedOut(rs.getInt("yearofpassedout"));
		                user.setUpdatedUser(rs.getString("updateduser"));
		                user.setCreateTime(rs.getString("createTime"));
		                user.setUpdateTime(rs.getString("updateTime"));
		                return user;
    	            }
    	        });
    }
    
    public void DeleteUser(int id)
    {
    	String fname="C:\\Users\\gokul\\Documents\\candidatemanagement\\userlogs.txt";
		String s = "ID-" + id + " : user is deleted  \n";
		Logging(fname, s);
	    
    	this.jd.update("Delete from candidate where id = ?", id);
    	//System.out.println("Candidate" + id + " is deleted");
    }
	
    
	@SuppressWarnings("deprecation")
	public List<User> SearchUser(String firstName)
    {
		
		//System.out.println("Search with "+ firstName + " name");
		List<User> temp = this.jd.query(
		        "select id,max(vid) as vid,firstname,lastname,email,role,location,contact,dob,doj,fathername,mothername,address,collegename,dept,skill,yearofpassedout,updateduser,createtime,updatetime from candidate where id >0 group by id",
		        new RowMapper<User>() 
		        {
		            public User mapRow(ResultSet rs, int rowNum) throws SQLException 
		            {
		                User user = new User();
		                user.setId(rs.getInt("id"));
		                user.setVid(rs.getInt("vid"));
		                return user;
		            }
		        });
		
		List<User> temp2 = new ArrayList<User>();
	    
		for(User temp3 : temp)
		{
			this.jd.query(
		        "select * from candidate where id = ? and vid = ? and firstname = ?",
		        new Object[]{temp3.getId(),temp3.getVid(),firstName},
		        new RowMapper<User>() 
		        {
		            public User mapRow(ResultSet rs, int rowNum) throws SQLException 
		            {
		                User user = new User();
		                user.setId(rs.getInt("id"));
		                user.setVid(rs.getInt("vid"));
		                user.setFirstName(rs.getString("firstname"));
		                user.setLastName(rs.getString("lastname"));
		                user.setEmail(rs.getString("email"));
		                user.setRole(rs.getString("role"));
		                user.setLocation(rs.getString("location"));
		                user.setContact(rs.getString("contact"));
		                user.setDob(rs.getString("dob"));
		                user.setDoj(rs.getString("doj"));
		                user.setFatherName(rs.getString("fathername"));
		                user.setMotherName(rs.getString("mothername"));
		                user.setAddress(rs.getString("address"));
		                user.setCollegeName(rs.getString("collegename"));
		                user.setDept(rs.getString("dept"));
		                user.setSkill(rs.getString("skill"));
		                user.setYearOfPassedOut(rs.getInt("yearofpassedout"));
		                user.setUpdatedUser(rs.getString("updateduser"));
		                user.setCreateTime(rs.getString("createTime"));
		                user.setUpdateTime(rs.getString("updateTime"));
		                temp2.add(user);
		                return user;
		            }
		        });
		}
		
		if(temp2.isEmpty())
		{
			User user = new User();
			user.setFirstName("empty");
			temp2.add(user);
		}
		
		return temp2;    	
    }
    
    public void UpdateUser(User user)
    {
    	String fname="C:\\Users\\gokul\\Documents\\candidatemanagement\\userlogs.txt";
		String s = "ID-" + user.getId() + " : user " + user.getFirstName() +" is updated with vid : "+user.getVid()+1 + " by " +user.getUpdatedUser() + " at " + user.getUpdateTime() + " \n"; 
		Logging(fname, s);
	    
    	this.jd.update("insert into candidate (id,firstname,lastname,email,role,location,contact,dob,doj,fathername,mothername,address,collegename,dept,skill,yearofpassedout,updateduser,createtime,updatetime) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", user.getId(), user.getFirstName(),user.getLastName(),user.getEmail(),user.getRole(),user.getLocation(),user.getContact(),user.getDob(),user.getDoj(),user.getFatherName(),user.getMotherName(),user.getAddress(),user.getCollegeName(),user.getDept(),user.getSkill(),user.getYearOfPassedOut(),user.getUpdatedUser(),user.getCreateTime(),user.getUpdateTime());
    	//System.out.println("User "+user.getId() +" Updated Successfull");
    }
	
	@SuppressWarnings("deprecation")
	public List<User> UserAll()
	{
		List<User> temp = this.jd.query(
		        "select id,max(vid) as vid,firstname,lastname,email,role,location,contact,dob,doj,fathername,mothername,address,collegename,dept,skill,yearofpassedout,updateduser,createtime,updatetime from candidate where id >0 group by id",
		        new RowMapper<User>() 
		        {
		            public User mapRow(ResultSet rs, int rowNum) throws SQLException 
		            {
		                User user = new User();
		                user.setId(rs.getInt("id"));
		                user.setVid(rs.getInt("vid"));
		                return user;
		            }
		        });
		
		List<User> temp2 = new ArrayList<User>();
	    
		for(User temp3 : temp)
		{
			this.jd.query(
		        "select * from candidate where id = ? and vid = ?",
		        new Object[]{temp3.getId(),temp3.getVid()},
		        new RowMapper<User>() 
		        {
		            public User mapRow(ResultSet rs, int rowNum) throws SQLException 
		            {
		                User user = new User();  
		                user.setId(rs.getInt("id"));
		                user.setVid(rs.getInt("vid"));
		                user.setFirstName(rs.getString("firstname"));
		                user.setLastName(rs.getString("lastname"));
		                user.setEmail(rs.getString("email"));
		                user.setRole(rs.getString("role"));
		                user.setLocation(rs.getString("location"));
		                user.setContact(rs.getString("contact"));
		                user.setDob(rs.getString("dob"));
		                user.setDoj(rs.getString("doj"));
		                user.setFatherName(rs.getString("fathername"));
		                user.setMotherName(rs.getString("mothername"));
		                user.setAddress(rs.getString("address"));
		                user.setCollegeName(rs.getString("collegename"));
		                user.setDept(rs.getString("dept"));
		                user.setSkill(rs.getString("skill"));
		                user.setYearOfPassedOut(rs.getInt("yearofpassedout"));
		                user.setUpdatedUser(rs.getString("updateduser"));
		                user.setCreateTime(rs.getString("createTime"));
		                user.setUpdateTime(rs.getString("updateTime"));
		                temp2.add(user);
		                return user;
		            }
		        });
		}
		return temp2;
	}
	
	
	public List<Location> LocationWiseCount()
	{

		List<Location> temp2 = new ArrayList<Location>();
	    
			this.jd.query(
		        "select location ,count(*) as count from trends group by location",
		        new RowMapper<User>() 
		        {
		            public User mapRow(ResultSet rs, int rowNum) throws SQLException 
		            {
		                User user = new User();
		                Location loc = new Location();
		                loc.setName(rs.getString("location"));
		                loc.setValue(rs.getInt("count"));
		                temp2.add(loc);
		                return user;
		            }
		        });
			
		return temp2;
	}
	
	public List<Location> SkillWiseCount()
	{

		List<Location> temp2 = new ArrayList<Location>();
	    
			this.jd.query(
		        "select skill ,count(*) as count from trends group by skill",
		        new RowMapper<User>() 
		        {
		            public User mapRow(ResultSet rs, int rowNum) throws SQLException 
		            {
		                User user = new User();
		                Location loc = new Location();
		                loc.setName(rs.getString("skill"));
		                loc.setValue(rs.getInt("count"));
		                temp2.add(loc);
		                return user;
		            }
		        });
	
		return temp2;
	}
	
	public List<Location> RoleWiseCount()
	{
		List<Location> temp2 = new ArrayList<Location>();
	    
			this.jd.query(
		        "select role ,count(*) as count from trends group by role",
		        new RowMapper<User>() 
		        {
		            public User mapRow(ResultSet rs, int rowNum) throws SQLException 
		            {
		                User user = new User();
		                Location loc = new Location();
		                loc.setName(rs.getString("role"));
		                loc.setValue(rs.getInt("count"));
		                temp2.add(loc);
		                return user;
		            }
		        });

		return temp2;
	}
	
	public List<Location> YearWiseCount()
	{
		List<Location> temp2 = new ArrayList<Location>();
	    
			this.jd.query(
		        "select substring(doj,1,4) as 'year',count(substring(doj,1,4)) as 'count' from trends group by substring(doj,1,4);",
		        new RowMapper<User>() 
		        {
		            public User mapRow(ResultSet rs, int rowNum) throws SQLException 
		            {
		                User user = new User();
		                Location loc = new Location();
		                loc.setName(rs.getString("year"));
		                loc.setValue(rs.getInt("count"));
		                temp2.add(loc);
		                return user;
		            }
		        });
			
		return temp2;
	}
	
	public static void Logging(String fname, String s) 
	{
		try
		{
			BufferedWriter out = new BufferedWriter(new FileWriter(fname, true));
			out.write(s);
			out.close();
		} 
		catch (IOException e) 
		{
			System.out.println(" log.txt : access denied " + e);
		}
	}
	
//	@SuppressWarnings({ "rawtypes" })
//	public Map<String,Integer> LocationWiseCount()
//    {
//		this.jd.execute("create table ll as select id,max(vid),location from candidate group by id");
//		
//		Map<String,Integer> temp2 = new HashMap<String,Integer>();
//	    
//			this.jd.query(
//		        "select location ,count(*) as count from ll group by location;",
//		        new RowMapper<Map>() 
//		        {
//		            public Map<String,Integer> mapRow(ResultSet rs, int rowNum) throws SQLException 
//		            {
//		            	Map<String,Integer> temp3 = new HashMap<String,Integer>();
//		                temp2.put(rs.getString("location"),rs.getInt("count"));
//		                return temp3;
//		            }
//		        });
//		
//		this.jd.execute("drop table ll");
//		System.out.println("Table is dropped");
//		
//		return temp2;    	
//    }
//	
//	@SuppressWarnings({ "rawtypes" })
//	public Map<String,Integer> SkillWiseCount()
//    {
//		this.jd.execute("create table ll as select id,max(vid),skill from candidate group by id");
//		
//		Map<String,Integer> temp2 = new HashMap<String,Integer>();
//	    
//			this.jd.query(
//		        "select skill ,count(*) as count from ll group by skill;",
//		        new RowMapper<Map>() 
//		        {
//		            public Map<String,Integer> mapRow(ResultSet rs, int rowNum) throws SQLException 
//		            {
//		            	Map<String,Integer> temp3 = new HashMap<String,Integer>();
//		                temp2.put(rs.getString("skill"),rs.getInt("count"));
//		                return temp3;
//		            }
//		        });
//		
//		this.jd.execute("drop table ll");
//		System.out.println("Table is dropped");
//		
//		return temp2;    	
//    }


}
