package com.capgemini.onlinetestmanagementsystem.util;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import com.capgemini.onlinetestmanagementsystem.dto.OnlineTest;
import com.capgemini.onlinetestmanagementsystem.dto.User;

public class UserRepository {
	
	static Map<Long, User> users = new HashMap<Long, User>();;
	
	static	{
		TestRepository testRepository = new TestRepository();
		OnlineTest test = testRepository.getTest(BigInteger.valueOf(1));
		
		User admin1 = new User(123456L, "Admin1", test, true, "Admin1@123");
		
		users.put(admin1.getUserId(), admin1);
		
		User admin2 = new User(123457L, "Admin2", test, true, "Admin2@123");
		
		users.put(admin2.getUserId(), admin2);
		
	}
	
	public Boolean addUser(User user)
	{
		users.put(user.getUserId(),user);
		return true;
	}
	
	public User getUser(Long id)
	{
		if(users.containsKey(id)) 
			return (User) users.get(id);
		else
			return null;
	}
	
}
