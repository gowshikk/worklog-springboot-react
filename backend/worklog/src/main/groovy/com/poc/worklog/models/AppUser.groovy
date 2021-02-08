package com.poc.worklog.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection="users")
class AppUser {
	
	public AppUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AppUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	
}
