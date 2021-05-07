package com.example.demo;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FrontController {

	@Autowired
	private UserService us;
	private final static Logger logging =  Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	@RequestMapping(value="/create" , method=RequestMethod.POST)
	public String createUser(@RequestBody User user)
	{
		logging.log(Level.INFO, "User : " + user.getFirstName() + " is Created at " + user.getCreateTime());
		us.createUser(user);
		return "Successfully Created";
	}
	
	@GetMapping(value="/view/{id}/{vid}")
	public User viewUser(@PathVariable int id,@PathVariable int vid)
	{
		return us.viewUser(id,vid);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public List<User> deleteUser(@PathVariable int id)
	{
		logging.log(Level.INFO, "Userid : " + id + " is Deleted ");
		return us.deleteUser(id);
	}
	
	@GetMapping(value="/search/{firstName}")
	public List<User> searchUser(@PathVariable String firstName)
	{
		return us.searchUser(firstName);
	}
	
	@RequestMapping(value="/edit" , method=RequestMethod.POST)
	public String updateUser(@RequestBody User user)
	{
		logging.log(Level.INFO, "User : " + user.getFirstName() + " is Updated by "+ user.getUpdatedUser() +" at " + user.getUpdateTime());
		us.updateUser(user);
		return "Update Successfully";
	}
	
	@GetMapping(value="/all")
	public List<User> userAll()
	{
		return us.userAll();
	}
	
	@GetMapping(value="/location")
	public List<Location> locationWiseCount()
	{
		return us.locationWiseCount();
	}
	
	@GetMapping(value="/skill")
	public List<Location> skillWiseCount()
	{
		return us.skillWiseCount();
	}
	
	@GetMapping(value="/role")
	public List<Location> roleWiseCount()
	{
		return us.roleWiseCount();
	}
	
	@GetMapping(value="/year")
	public List<Location> yearWiseCount()
	{
		return us.yearWiseCount();
	}
	
//	@GetMapping(value="/location")
//	public Map<String,Integer> locationWiseCount()
//	{
//		return us.locationWiseCount();
//	}
//	
//	@GetMapping(value="/skill")
//	public Map<String,Integer> skillWiseCount()
//	{
//		return us.skillWiseCount();
//	}
	
}
