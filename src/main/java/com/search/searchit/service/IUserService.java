package com.search.searchit.service;

import org.springframework.http.ResponseEntity;

import com.search.searchit.model.User;
import com.search.searchit.util.Response;

public interface IUserService {
	public ResponseEntity<Response> registration(User user);
}
