package controller;

import javax.inject.Named;

@Named
public class LoginController {
	
	private String userName;
	private String password;
	
	
	
	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public boolean checkUserName() {
		
		return false;
	}
	
	
	
	

}
