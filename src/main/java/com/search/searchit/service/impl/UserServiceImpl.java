package com.search.searchit.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.search.searchit.dao.IUserDao;
import com.search.searchit.model.User;
import com.search.searchit.service.IUserService;
import com.search.searchit.util.Response;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired IUserDao userDao;

	@Override
	public ResponseEntity<Response> create(User user) {
		User createdUser =  userDao.save(user);
		return new ResponseEntity<Response>(new Response(Boolean.TRUE, "user created sucessfully", createdUser), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Response> update(User user) {
		User updatedUser =  userDao.save(user);
		return new ResponseEntity<Response>(new Response(Boolean.TRUE, "user updated sucessfully", updatedUser), HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<Response> getUser(Long userId) {
		Optional<User> featchedUser = userDao.findById(userId); 
		if (featchedUser.isPresent()) {
			return new ResponseEntity<Response>(new Response(Boolean.TRUE, "User fetched sucessfully", featchedUser), HttpStatus.OK);
		}
		return new ResponseEntity<Response>(new Response(Boolean.FALSE, "No user is presented with Id", featchedUser), HttpStatus.NOT_FOUND);
	}
	
	@Override
	public ResponseEntity<Response> delete(Long userId) {
		userDao.deleteById(userId);
		return new ResponseEntity<Response>(new Response(Boolean.TRUE, "user deleted sucessfully", null), HttpStatus.OK);
		
	}
	
	@Override
	public ResponseEntity<Response> login(String email, String password) {
		User user = userDao.findUserByEmail(email);
		boolean isValidUser = user.getPassword().equals(password);
		if(isValidUser) {
			return new ResponseEntity<Response>(new Response(Boolean.TRUE, "User validated Sucessfully", user), HttpStatus.OK);
		}
		return new ResponseEntity<Response>(new Response(Boolean.FALSE, "Invalid User", null), HttpStatus.NOT_ACCEPTABLE);
	}



}
