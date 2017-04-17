package com.spring.web.controller;

public class CustomLogin {

	public String getApplicationRole(String userName, String password, String string, String string2) {
		// TODO Auto-generated method stub
		System.out.println("User : "+userName);
		System.out.println("pasword : "+password);
		//here put the user mangnament source and validate de credentials 
		return "ROLE_USER";
	}

}
