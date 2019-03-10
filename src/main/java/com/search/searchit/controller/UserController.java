package com.search.searchit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.search.searchit.model.User;
import com.search.searchit.service.impl.UserServiceImpl;
import com.search.searchit.util.EncryptAndDecryptHelper;
import com.search.searchit.util.Response;

@RestController
public class UserController {

	@Autowired
	UserServiceImpl userService;

	@PostMapping("user/registration")
	public ResponseEntity<Response> createUser(@RequestBody User user) {
		/*try {
		user.setPassword(EncryptAndDecryptHelper.encrypt(user.getPassword(), "search_it"));
	} catch (Exception e) {
		e.printStackTrace();
	}*/
		return userService.create(user);
	}

	@PostMapping("user/update")
	public ResponseEntity<Response> userUpdate(@RequestBody User user)  {
		return userService.update(user);
	}

	@PostMapping("user/getUser")
	public ResponseEntity<Response> getUser(Long userId ) {
		return userService.getUser(userId);
	}

	@PostMapping("user/delete")
	public ResponseEntity<Response> userDelete(@RequestParam Long userId ) {
		return userService.delete(userId);
	}

	@PostMapping("user/login")
	public ResponseEntity<Response> userLogIn(@RequestParam String email, @RequestParam String password ) {
		return userService.login(email, password);
	}





}
