package com.capgemini.onlinetestmanagementsystem.DaoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.capgemini.onlinetestmanagementsystem.dao.TestDao;
import com.capgemini.onlinetestmanagementsystem.dto.OnlineTest;
import com.capgemini.onlinetestmanagementsystem.dto.Question;
import com.capgemini.onlinetestmanagementsystem.service.QuestionService;

public class TestDaoTest {

	@Test
	public void checkAddTest()
	{
		TestDao testDao = new TestDao();
		
		Set<Question> questions = new HashSet<Question>();  
		
		QuestionService question = new QuestionService();
		
		for(int i=1 ; i <= 5 ; i++) {
			Question q = (Question) question.getQuestion(BigInteger.valueOf(i));
			questions.add(q);
		}
		
		OnlineTest test = new OnlineTest(BigInteger.valueOf(1), "Aptitude", questions, new BigDecimal(20));
		Boolean check = testDao.addTest(test);
		assertTrue(check);
	}
	
	@Test
	public void checkGetTest()
	{
		TestDao testDao = new TestDao();
		OnlineTest test = testDao.getTest(BigInteger.valueOf(1));
		assertEquals(test.getTestTitle(),"Aptitude");
	}
}
