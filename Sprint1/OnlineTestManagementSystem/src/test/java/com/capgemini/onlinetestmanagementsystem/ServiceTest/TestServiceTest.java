package com.capgemini.onlinetestmanagementsystem.ServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.capgemini.onlinetestmanagementsystem.dto.OnlineTest;
import com.capgemini.onlinetestmanagementsystem.dto.Question;
import com.capgemini.onlinetestmanagementsystem.service.QuestionService;
import com.capgemini.onlinetestmanagementsystem.service.TestService;

public class TestServiceTest {
	
	@Test
	public void checkAddTest()
	{
		TestService testService = new TestService();
		
		Set<Question> questions = new HashSet<Question>();  
		
		QuestionService question = new QuestionService();
		
		for(int i=1 ; i <= 5 ; i++) {
			Question q = (Question) question.getQuestion(BigInteger.valueOf(i));
			questions.add(q);
		}
		
		OnlineTest test = new OnlineTest(BigInteger.valueOf(1), "Aptitude", questions, new BigDecimal(20));
		
		Boolean check = testService.addTest(test);
		assertTrue(check);
	}
	
	@Test
	public void checkGetTest()
	{
		TestService testService = new TestService();
		OnlineTest test = testService.getTest(BigInteger.valueOf(1));
		assertEquals(test.getTestTitle(),"Aptitude");
	}

	@Test
	public void checkAssignTest()
	{
		TestService testService = new TestService();
		Boolean check = testService.assignTest(123456L, BigInteger.valueOf(1));
		assertTrue(check);
	}
	
	@Test
	public void checkGetResult()
	{
		TestService testService = new TestService();
		Set<Question> questions = new HashSet<Question>();  
		
		QuestionService question = new QuestionService();
		
		for(int i=1 ; i <= 5 ; i++) {
			Question q = (Question) question.getQuestion(BigInteger.valueOf(i));
			questions.add(q);
		}
		
		OnlineTest test = new OnlineTest(BigInteger.valueOf(1), "Aptitude", questions, new BigDecimal(20));
		test.setTestMarksScored(new BigDecimal(12));
		assertEquals(testService.getResult(test),12);
	}
}
