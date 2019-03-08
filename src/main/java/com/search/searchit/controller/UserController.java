package com.search.searchit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.search.searchit.model.User;
import com.search.searchit.service.impl.UserServiceImpl;
import com.search.searchit.util.EncryptAndDecryptHelper;
import com.search.searchit.util.Response;

@RestController
public class UserController {

@Autowired
UserServiceImpl userService;

@PostMapping("/registration")
public ResponseEntity<Response> doUserRegistration(@RequestBody User user) {
	try {
		user.setPassword(EncryptAndDecryptHelper.encrypt(user.getPassword(), "search_it"));
	} catch (Exception e) {
		e.printStackTrace();
	}
	return userService.registration(user);
}

}
