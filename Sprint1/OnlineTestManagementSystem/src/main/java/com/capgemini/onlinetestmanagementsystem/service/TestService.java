package com.capgemini.onlinetestmanagementsystem.service;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.capgemini.onlinetestmanagementsystem.dao.TestDao;
import com.capgemini.onlinetestmanagementsystem.dto.OnlineTest;

public class TestService implements TestInterface{

	TestDao testDao = new TestDao();
	public Boolean addTest(OnlineTest object)
	{	
		Boolean check = testDao.addTest(object);
		if(check==true)
			return true;
		else
			return false;
	}
	
	public OnlineTest getTest(BigInteger id)
	{
		OnlineTest test = testDao.getTest(id);
		return test;
	}
	
	public Boolean assignTest(Long userId, BigInteger testId)
	{
		TestDao testDao = new TestDao();
		Boolean check = testDao.assignTest(userId,testId);
		if(check==true)
			return true;
		else
			return false;
	}
	
	public BigDecimal getResult(OnlineTest test)
	{
		return test.getTestMarksScored();
	}
}
