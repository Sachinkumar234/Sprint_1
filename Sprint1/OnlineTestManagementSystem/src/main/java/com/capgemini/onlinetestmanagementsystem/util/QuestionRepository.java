package com.capgemini.onlinetestmanagementsystem.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import com.capgemini.onlinetestmanagementsystem.dto.Question;

public class QuestionRepository {

	static Map<BigInteger, Question> questions = new HashMap<BigInteger, Question>();
	
	static {
		QuestionRepository quesRepo = new QuestionRepository();
		Question question1= new Question(BigInteger.valueOf(1),"1) 65.25,2) 56.25,3) 65,4) 56".split(","),
				"If each side of a square is increased by 25%, find the percentage change in its area?",2,new BigDecimal(4));
		quesRepo.addQuestion(question1);
		System.out.println("Question 1 added successfully");
	}
	
	public Boolean addQuestion(Question question)
	{
		questions.put(question.getQuestionId(), question);
		return true;
	}
	
	public Question getQuestion(BigInteger id)
	{
		if(questions.containsKey(id)) 
			return (Question) questions.get(id);
		else
			return null;
	}
}
