package com.search.searchit.controller;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.search.searchit.model.User;
import com.search.searchit.service.impl.UserServiceImpl;
import com.search.searchit.util.Response;
import com.search.searchit.validation.ValidationHelper;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	UserServiceImpl userService;
	@Autowired
	ValidationHelper validation;
	
	@PostMapping("/user/registration")
	public ResponseEntity<Response> createUser(@RequestBody User user) {
		/*try {
		user.setPassword(EncryptAndDecryptHelper.encrypt(user.getPassword(), "search_it"));
	} catch (Exception e) {
		e.printStackTrace();
	}*/
		Response validationResponse = validation.validateUser(user);
		if(validationResponse.getSuccess().equals(Boolean.FALSE)) {
			return new ResponseEntity<Response>(validationResponse, HttpStatus.BAD_REQUEST);
		}
		return userService.create(user);
	}

	@PostMapping("/user/update")
	public ResponseEntity<Response> userUpdate(@RequestBody User user)  {
		Response validationResponse = validation.validateUser(user);
		if (validationResponse.getSuccess().equals(Boolean.FALSE)) {
			return new ResponseEntity<Response>(validationResponse, HttpStatus.BAD_REQUEST);
		}
		return userService.update(user);
	}

	@GetMapping("/user/getUser")
	public ResponseEntity<Response> getUser(@Valid @NotNull @RequestParam Long userId ) {
		return userService.getUser(userId);
	}

	@PostMapping("/user/delete")
	public ResponseEntity<Response> userDelete(@Valid @NotNull @RequestParam Long userId ) {
		return userService.delete(userId);
	}

	/*@PostMapping("/user/login")
	public ResponseEntity<Response> userLogIn(@Valid @Email @RequestParam String email, @Valid @NotNull @RequestParam String password ) {
		return userService.login(email, password);
	}*/





}
