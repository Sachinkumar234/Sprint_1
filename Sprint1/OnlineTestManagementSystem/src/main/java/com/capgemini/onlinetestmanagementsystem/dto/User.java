package com.capgemini.onlinetestmanagementsystem.dto;

public class User {
	private Long userId;
	private String userName;
	private OnlineTest userTest;
	private Boolean isAdmin;
	private String userPassword;
	
	
	public User(Long userId, String userName, OnlineTest userTest, Boolean isAdmin, String userPassword) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userTest = userTest;
		this.isAdmin = isAdmin;
		this.userPassword = userPassword;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public OnlineTest getUserTest() {
		return userTest;
	}
	public void setUserTest(OnlineTest userTest) {
		this.userTest = userTest;
	}
	public Boolean getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	
}
