package com.gcu.business;

import java.util.ArrayList;

import com.gcu.model.LoginModel;

public class LoginBusinessService 
{	
	ArrayList<LoginModel> users;
	
	public LoginBusinessService() 
	{
		users = new ArrayList<LoginModel>();
		users.add(new LoginModel("james", "gwozdz"));
		users.add(new LoginModel("dylan", "kellett"));
	}
	
	public boolean checkLogin(String username, String password) {
		for (int i = 0; i < users.size(); i++) {
			if (username.toLowerCase().trim().equals(users.get(i).getUsername()) && password.toLowerCase().trim().equals(users.get(i).getPassword())) return true;
		}
		return false;
	}
}
