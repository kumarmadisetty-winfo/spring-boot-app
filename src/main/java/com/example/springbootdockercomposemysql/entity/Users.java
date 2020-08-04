package com.example.springbootdockercomposemysql.entity;

import java.util.List;

public class Users {

	public Users(List<User> users) {
		super();
		this.users = users;
	}

	List<User> users;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}
