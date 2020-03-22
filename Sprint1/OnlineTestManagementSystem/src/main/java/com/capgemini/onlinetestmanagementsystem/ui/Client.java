package com.capgemini.onlinetestmanagementsystem.ui;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.capgemini.onlinetestmanagementsystem.dto.Question;
import com.capgemini.onlinetestmanagementsystem.Exception.ValidationException;
import com.capgemini.onlinetestmanagementsystem.dto.OnlineTest;
import com.capgemini.onlinetestmanagementsystem.dto.User;
import com.capgemini.onlinetestmanagementsystem.service.QuestionService;
import com.capgemini.onlinetestmanagementsystem.service.TestService;
import com.capgemini.onlinetestmanagementsystem.service.UserService;
import com.capgemini.onlinetestmanagementsystem.util.TestRepository;

public class Client {
	static Scanner input = new Scanner(System.in);
	
	//Add User to UserRepository
	public static void users() throws ValidationException
	{
		TestRepository testRepository = new TestRepository();
		OnlineTest test = testRepository.getTest(BigInteger.valueOf(1));
		Boolean check;
		User user1 = new User(123458L, "User1", test, false, "User1@123");
		UserService userService = new UserService();
		try
		{
			check = userService.addUser(user1);
		}
		catch(ValidationException exception)
		{
			System.out.println(exception.getMessage());
			check=false;
		}
		if(check==true)
			System.out.println("User successfully added");
		else
			System.out.println("Adding user unsuccessful");
	}
	
	//Add Questions to QuestionRepository
	public static void questions()
	{
		QuestionService questionService = new QuestionService();
	
		Question question2= new Question(BigInteger.valueOf(2),"1) 1/4,2) 1/2,3) 3/4,4) 7/12".split(","),
				"A problem is given to three students whose chances of solving it are 1/2, 1/3 and 1/4 respectively. What is the probability that the problem will be solved?",3,new BigDecimal(4));
		questionService.addQuestion(question2);
		Boolean check2 = questionService.addQuestion(question2);
		if(check2==true)
			System.out.println("Question 2 added successfully");
		else
			System.out.println("Question 2 not added");
		
		Question question3= new Question(BigInteger.valueOf(3),"1) 25200,2) 52000,3) 120,4) 24400".split(","),
				"Out of 7 consonants and 4 vowels, how many words of 3 consonants and 2 vowels can be formed?",1,new BigDecimal(4));
		questionService.addQuestion(question3);
		Boolean check3 = questionService.addQuestion(question3);
		if(check3==true)
			System.out.println("Question 3 added successfully");
		else
			System.out.println("Question 3 not added");
		
		Question question4= new Question(BigInteger.valueOf(4),"1) 2500,2) 2700,3) 2900,4) 3100".split(","),
				"In an election between two candidates, one got 55% of the total valid votes, 20% of the votes were invalid. If the total number of votes was 7500, the number of valid votes that the other candidate got, was :",2,new BigDecimal(4));
		questionService.addQuestion(question4);
		Boolean check4 = questionService.addQuestion(question4);
		if(check4==true)
			System.out.println("Question 4 added successfully");
		else
			System.out.println("Question 4 not added");
		
		Question question5= new Question(BigInteger.valueOf(5),"1) 945,2) 678,3) 439,4) 568".split(","),
				"The sum of all two digit numbers divisible by 5 is",1,new BigDecimal(4));
		questionService.addQuestion(question5);
		Boolean check5 = questionService.addQuestion(question5);
		if(check5==true)
			System.out.println("Question 5 added successfully");
		else
			System.out.println("Question 5 not added");
	}
	
	//Add Test to TestRepository
	public static void tests()
	{
		TestService testService = new TestService();
		
		Set<Question> questions = new HashSet<Question>();  
		
		QuestionService question = new QuestionService();
		
		for(int id=1 ; id <= 5 ; id++) {
			Question q = (Question) question.getQuestion(BigInteger.valueOf(id));
			questions.add(q);
		}
		
		OnlineTest test = new OnlineTest(BigInteger.valueOf(1), "Aptitude", questions, new BigDecimal(20));
		Boolean check = testService.addTest(test);
		if(check==true)
			System.out.println("Test added successfully");
		else
			System.out.println("Test not added");
		
	}
	
	//Add Test to TestRepository by taking inputs from admin
	public static void test()
	{
		TestService testService = new TestService();
		
		Set<Question> questions = new HashSet<Question>();  
		
		QuestionService question = new QuestionService();
		
		System.out.println("Enter start and ending question id you want to put in a test:");
		int start = input.nextInt();
		int end = input.nextInt();
		for(int id=start ; id <= end ; id++) {
			Question q = (Question) question.getQuestion(BigInteger.valueOf(id));
			questions.add(q);
		}
		
		System.out.println("Enter test Id");
		int testId = input.nextInt();
		
		input.nextLine();
		System.out.println("Enter test title");
		String name = input.nextLine();
		
		int totalMarks = (end-(start-1))*4;
		
		OnlineTest test = new OnlineTest(BigInteger.valueOf(testId), name, questions, new BigDecimal(totalMarks));
		//Adding test
		testService.addTest(test);
		
		OnlineTest getTest = testService.getTest(BigInteger.valueOf(testId));
		System.out.println("Test title:"+getTest.getTestTitle());
		System.out.println("Test added successfully");
		
	}
	
	//Assign Test to the user
	public static void assignTest()
	{		
		System.out.println("Enter UserId:");
		Long userId = input.nextLong();
		System.out.println("Enter test Id:");
		int testId = input.nextInt();
		
		TestService testService = new TestService();
		Boolean check = testService.assignTest(userId, BigInteger.valueOf(testId));
		if(check==true)
			System.out.println("Successfully assigned");
		else
			System.out.println("Assign unsuccessfully");
	}
	
	//Main starts
	public static void main(String [] args) throws ValidationException
	{	
		UserService userService = new UserService();
		
		questions();
		tests();
		users();
		
		System.out.println();
		System.out.println("Enter your User Id:");
		Long userId = input.nextLong();
		System.out.println("Enter your password:");
		input.nextLine();
		String password = input.nextLine();
		
		try {
			User user = userService.getUser(userId);
			String password1 = user.getUserPassword();
			
			if(password.equals(password1))
			{
				if(user.getIsAdmin()==true)
				{
					while(true)
					{
						System.out.println("1. Add Test");
						System.out.println("2. Assign Test");
						System.out.println("3. Exit");

						System.out.println("Enter your choice:");
						int choice = input.nextInt();
						
						if(choice==1)
						{
							test();
						}
						if(choice==2)
						{
							assignTest();
						}
						if(choice==3)
						{
							break;
						}
					}
				}
				//If not admin than test will be shown on screen
				else
				{
					System.out.println("----------Attempt test assigned to you----------");
					OnlineTest test = userService.getTest(user);
					if(test==null)
					{
						System.out.println("Record not Fetched ");
					}
					else
					{
						Set<Question> questions = test.getTestQuestions();
						BigDecimal marks= new BigDecimal(0);
						BigDecimal marks1;
						BigDecimal result = null;
						
						for(Question question: questions)
						{
							System.out.println(question.getQuestionTitle());
							String options[] = question.getQuestionOptions();
							System.out.println(options[0]+"\n"+options[1]+"\n"+options[2]+"\n"+options[3]);
							
							System.out.println("Enter your choice:");
							int chosenAnswer = input.nextInt();
							
							question.setChosenAnswer(chosenAnswer);
							if(question.getChosenAnswer()==question.getQuestionAnswer())
								question.setMarksScored(new BigDecimal(4));
							else
								question.setMarksScored(new BigDecimal(0));
							marks1 = question.getMarksScored();
							result = marks.add(marks1);
							marks=result;
							//System.out.println(result);
						}
						test.setTestMarksScored(result);
						System.out.println("Do you want to display result:[1/0]");
						int display = input.nextInt();
						if(display==1)
						{
							TestService test1 = new TestService();
							BigDecimal score = test1.getResult(test);
							System.out.println("You scored:"+score+"/20");
						}
						
						input.close();
					}
				}
				
			}
			else
			{
				System.out.println("Enter valid credentials");
			}
			
		}
		catch(NullPointerException e)
		{
			System.out.println("Please enter valid credentials");
		}	
	}
	
}
