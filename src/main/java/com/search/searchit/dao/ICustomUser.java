package com.search.searchit.dao;

import java.util.List;

import com.search.searchit.model.User;

public interface ICustomUser {

	public List<User> getUserByName(String name);
	
	public User findUserByEmail(String email);
	
}
