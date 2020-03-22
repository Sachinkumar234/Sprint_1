package com.capgemini.onlinetestmanagementsystem.service;

import com.capgemini.onlinetestmanagementsystem.Exception.ValidationException;
import com.capgemini.onlinetestmanagementsystem.dao.UserDao;
import com.capgemini.onlinetestmanagementsystem.dto.OnlineTest;
import com.capgemini.onlinetestmanagementsystem.dto.User;

public class UserService implements UserInterface{
	UserDao userDao = new UserDao();
	public Boolean addUser(User user) throws ValidationException
	{	
		if(user.getUserId()<0)
		{
			throw new ValidationException("User Id cannot be negative");
		}
		
		if(user.getUserName().isEmpty())
		{
			throw new ValidationException("Empty User Name");
		}
		
		if(user.getUserPassword().isEmpty())
		{
			throw new ValidationException("Empty Password");
		}
		
		if(user.getUserTest()==null)
		{
			throw new ValidationException("Test cannot be Null");
		}
		
		Boolean check = userDao.addUser(user);
		if(check==true)
			return true;
		else
			return false;
	}
	
	public User getUser(Long userId)
	{
		User user= userDao.getUser(userId);
		return user;
	}
	
	public OnlineTest getTest(User user)
	{
		return user.getUserTest();
	}
}
