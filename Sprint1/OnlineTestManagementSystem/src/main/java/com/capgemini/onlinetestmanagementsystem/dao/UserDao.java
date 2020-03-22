package com.capgemini.onlinetestmanagementsystem.dao;

import com.capgemini.onlinetestmanagementsystem.dto.User;
import com.capgemini.onlinetestmanagementsystem.util.UserRepository;

public class UserDao {

	UserRepository userRepo = new UserRepository();
	
	public Boolean addUser(User obj)
	{
		Boolean check = userRepo.addUser(obj);
		if(check==true)
			return true;
		else
			return false;
	}
	
	public User getUser(Long userId)
	{
		User user = userRepo.getUser(userId);
		return user;
	}
}
