package com.javaee.entity;

public class User {
<<<<<<< HEAD
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
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public User(){}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
=======
	public String username;
	public String password;
	public Integer age;
	public String getUsername() {
		return username;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
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
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public User(){}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", age=" + age + "]";
	}
	
>>>>>>> branch 'master' of git@github.com:hongyingwei/JavaWeb.git
	
}
