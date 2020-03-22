package com.capgemini.onlinetestmanagementsystem.util;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import com.capgemini.onlinetestmanagementsystem.dto.OnlineTest;
import com.capgemini.onlinetestmanagementsystem.dto.User;


public class TestRepository {

	static Map<BigInteger, OnlineTest> tests = new HashMap<BigInteger, OnlineTest>();
	
	public Boolean addTest(OnlineTest test)
	{
		tests.put(test.getTestId(),test);
		return true;
	}
	
	public OnlineTest getTest(BigInteger id)
	{
		if(tests.containsKey(id))
		{
			return (OnlineTest) tests.get(id);
		}
		else
			return null;
	}
	
	public Boolean assignTest(Long userId, BigInteger testId)
	{
		UserRepository userRepo = new UserRepository();
		User user = userRepo.getUser(userId);
		TestRepository testRepo = new TestRepository();
		OnlineTest test = testRepo.getTest(testId);
		user.setUserTest(test);
		return true;
	}
}
