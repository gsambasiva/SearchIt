package com.search.searchit.service.impl;

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
	public ResponseEntity<Response> registration(User user) {
		User createdUser =  userDao.save(user);
		return new ResponseEntity<Response>(new Response(Boolean.TRUE, "user created sucessfully", createdUser), HttpStatus.OK);
	}
	

}
