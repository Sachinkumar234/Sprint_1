package com.capgemini.onlinetestmanagementsystem.service;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.capgemini.onlinetestmanagementsystem.dto.OnlineTest;

public interface TestInterface {
	
	public Boolean addTest(OnlineTest object);
	
	public OnlineTest getTest(BigInteger id);
	
	public Boolean assignTest(Long userId, BigInteger testId);
	
	public BigDecimal getResult(OnlineTest test);

}
