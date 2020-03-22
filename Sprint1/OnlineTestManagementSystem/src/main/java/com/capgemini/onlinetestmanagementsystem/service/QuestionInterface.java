package com.capgemini.onlinetestmanagementsystem.service;

import java.math.BigInteger;

import com.capgemini.onlinetestmanagementsystem.dto.Question;

public interface QuestionInterface {
	public Boolean addQuestion(Question object);
	public Question getQuestion(BigInteger id);
}
