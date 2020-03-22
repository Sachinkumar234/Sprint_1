package com.capgemini.onlinetestmanagementsystem.DaoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.capgemini.onlinetestmanagementsystem.dao.UserDao;
import com.capgemini.onlinetestmanagementsystem.dto.User;

public class UserDaoTest {
	
	@Test
	public void checkAddUser()
	{
		UserDao userDao = new UserDao();
		User user = userDao.getUser(123456L);
		Boolean check = userDao.addUser(user);
		assertTrue(check);
	}
	
	@Test
	public void checkGetUser()
	{
		UserDao userDao = new UserDao();
		User user = userDao.getUser(123456L);
		assertEquals(user.getUserName(),"Admin1");
	}
	
}
