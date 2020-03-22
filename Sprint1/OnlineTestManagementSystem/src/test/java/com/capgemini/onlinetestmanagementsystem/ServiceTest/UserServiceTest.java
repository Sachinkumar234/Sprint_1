package com.capgemini.onlinetestmanagementsystem.ServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.capgemini.onlinetestmanagementsystem.Exception.ValidationException;
import com.capgemini.onlinetestmanagementsystem.dao.TestDao;
import com.capgemini.onlinetestmanagementsystem.dto.OnlineTest;
import com.capgemini.onlinetestmanagementsystem.dto.Question;
import com.capgemini.onlinetestmanagementsystem.dto.User;
import com.capgemini.onlinetestmanagementsystem.service.QuestionService;
import com.capgemini.onlinetestmanagementsystem.service.UserService;

public class UserServiceTest {

	@Test
	public void checkAddUser() throws ValidationException
	{
		UserService userService = new UserService();
		User user = userService.getUser(123456L);
		Boolean check = userService.addUser(user);
		assertTrue(check);
	}
	
	@Test
	public void checkGetUser()
	{
		UserService userService = new UserService();
		User user = userService.getUser(123456L);
		assertEquals(user.getUserName(),"Admin1");
	}
	
	@Test
	public void checkGetTest()
	{
		UserService userService = new UserService();
		User user = userService.getUser(123456L);
		
		TestDao testDao = new TestDao();
		
		Set<Question> questions = new HashSet<Question>();  
		
		QuestionService question = new QuestionService();
		
		for(int i=1 ; i <= 5 ; i++) {
			Question q = (Question) question.getQuestion(BigInteger.valueOf(i));
			questions.add(q);
		}
		
		OnlineTest test = new OnlineTest(BigInteger.valueOf(1), "Aptitude", questions, new BigDecimal(20));
		testDao.addTest(test);
		
		user.setUserTest(test);
		OnlineTest test1 = userService.getTest(user);
		assertEquals(test1.getTestId(),1);
	}
}
