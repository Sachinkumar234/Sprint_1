package com.capgemini.onlinetestmanagementsystem.DaoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.jupiter.api.Test;

import com.capgemini.onlinetestmanagementsystem.dao.QuestionDao;
import com.capgemini.onlinetestmanagementsystem.dto.Question;


public class QuestionDaoTest {

	@Test
	public void checkAddTest()
	{
		QuestionDao questionDao = new QuestionDao();
		
		Question question2= new Question(BigInteger.valueOf(2),"1) 1/4,2) 1/2,3) 3/4,4) 7/12".split(","),
				"A problem is given to three students whose chances of solving it are 1/2, 1/3 and 1/4 respectively. What is the probability that the problem will be solved?",3,new BigDecimal(4));
		Boolean check = questionDao.addQuestion(question2);
		assertTrue(check);
	}
	
	@Test
	public void checkGetTest()
	{
		QuestionDao questionDao = new QuestionDao();
		Question question = questionDao.getQuestion(BigInteger.valueOf(2));
		assertEquals(question.getQuestionAnswer(),3);
	}
}
