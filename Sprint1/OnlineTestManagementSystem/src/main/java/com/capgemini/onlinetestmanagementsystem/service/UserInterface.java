package com.capgemini.onlinetestmanagementsystem.service;

import com.capgemini.onlinetestmanagementsystem.Exception.ValidationException;
import com.capgemini.onlinetestmanagementsystem.dto.OnlineTest;
import com.capgemini.onlinetestmanagementsystem.dto.User;

public interface UserInterface {
	public Boolean addUser(User user)throws ValidationException;
	
	public User getUser(Long userId);
	
	public OnlineTest getTest(User user);
	
}
