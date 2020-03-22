package com.capgemini.onlinetestmanagementsystem.dao;

import java.math.BigInteger;

import com.capgemini.onlinetestmanagementsystem.dto.OnlineTest;
import com.capgemini.onlinetestmanagementsystem.util.TestRepository;

public class TestDao {
	
	TestRepository testRepository = new TestRepository();
	
	public Boolean addTest(OnlineTest object)
	{
		Boolean check = testRepository.addTest(object);
		if(check == true)
			return true;
		else
			return false;
	}
	
	public OnlineTest getTest(BigInteger id)
	{
		OnlineTest test = testRepository.getTest(id);
		return test;
	}
	
	public Boolean assignTest(Long userId, BigInteger testId)
	{
		TestRepository testRepo = new TestRepository();
		Boolean check = testRepo.assignTest(userId,testId);
		if(check==true)
			return true;
		else
			return false;
	}
}
