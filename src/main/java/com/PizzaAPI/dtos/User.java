package com.PizzaAPI.dtos;
import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class User {

	private String userName;
	private String userRole;
	private String userPhone;
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserRole() {
		return userRole;
	}
	
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	public String getUserPhone() {
		return userPhone;
	}
	
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	
	
	
}
