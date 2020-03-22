package com.capgemini.onlinetestmanagementsystem.service;

import java.math.BigInteger;

import com.capgemini.onlinetestmanagementsystem.dao.QuestionDao;
import com.capgemini.onlinetestmanagementsystem.dto.Question;

public class QuestionService implements QuestionInterface{
	
	QuestionDao questionDao = new QuestionDao();
	public Boolean addQuestion(Question object)
	{
		Boolean check = questionDao.addQuestion(object);
		if(check==true)
			return true;
		else
			return false;
	}
	
	public Question getQuestion(BigInteger id)
	{
		Question question = questionDao.getQuestion(id);
		return question;
	}
}
