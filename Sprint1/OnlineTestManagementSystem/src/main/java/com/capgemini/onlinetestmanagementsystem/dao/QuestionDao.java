package com.capgemini.onlinetestmanagementsystem.dao;

import java.math.BigInteger;

import com.capgemini.onlinetestmanagementsystem.dto.Question;
import com.capgemini.onlinetestmanagementsystem.util.QuestionRepository;

public class QuestionDao {
	
	QuestionRepository questionRepository = new QuestionRepository();
	public Boolean addQuestion(Question object) 
	{		
		Boolean check = questionRepository.addQuestion(object);
		if(check==true)
			return true;
		else
			return false;
	}
	
	public Question getQuestion(BigInteger id)
	{
		Question question = questionRepository.getQuestion(id);
		return question;
	}
	
}
