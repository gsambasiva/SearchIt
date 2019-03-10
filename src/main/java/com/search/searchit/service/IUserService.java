package com.search.searchit.service;

import org.springframework.http.ResponseEntity;

import com.search.searchit.model.User;
import com.search.searchit.util.Response;

public interface IUserService {
	public ResponseEntity<Response> create(User user);
	public ResponseEntity<Response> update(User user);
	public ResponseEntity<Response> getUser(Long userId);
	public ResponseEntity<Response> delete(Long userId);
	public ResponseEntity<Response> login(String email , String password);
}
	
