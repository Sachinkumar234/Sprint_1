package com.capgemini.onlinetestmanagementsystem.ServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

import com.capgemini.onlinetestmanagementsystem.dao.QuestionDao;
import com.capgemini.onlinetestmanagementsystem.dto.Question;
import com.capgemini.onlinetestmanagementsystem.service.QuestionService;

public class QuestionServiceTest {

	@Test
	public void checkAddQuestion()
	{
		QuestionDao questionDao = new QuestionDao();
		Question question = questionDao.getQuestion(BigInteger.valueOf(1));
		QuestionService questionService = new QuestionService();
		Boolean check = questionService.addQuestion(question);
		assertTrue(check);
	}
	
	@Test
	public void checkGetQuestion()
	{
		QuestionService questionService = new QuestionService();
		Question question = questionService.getQuestion(BigInteger.valueOf(1));
		assertEquals(question.getQuestionAnswer(),2);
	}
}
