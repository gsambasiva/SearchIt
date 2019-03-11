package com.search.searchit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.search.searchit.model.Question;
import com.search.searchit.service.impl.QuestionServiceImpl;
import com.search.searchit.util.Response;
import com.search.searchit.validation.ValidationHelper;

@RestController
public class QestionController {
	@Autowired QuestionServiceImpl serviceImpl;
	@Autowired ValidationHelper validation;
	@PostMapping("/question/askQuestion")
	public ResponseEntity<Response> askQuestion(@RequestBody Question question) {
		Response validationResponse = validation.validateQuestion(question);
		if(validationResponse.getSuccess().equals(Boolean.FALSE)) {
			return new ResponseEntity<Response>(validationResponse, HttpStatus.BAD_REQUEST);
		}
		return serviceImpl.createQuestion(question);
	}
	
	@PostMapping("/question/updateQuestion")
	public ResponseEntity<Response> updateQuestion(@RequestBody Question question) {
		Response validationResponse = validation.validateQuestion(question);
		if(validationResponse.getSuccess().equals(Boolean.FALSE)) {
			return new ResponseEntity<Response>(validationResponse, HttpStatus.BAD_REQUEST);
		}
		return serviceImpl.updateQuestion(question);
	}

	@PostMapping("/question/getQuestion")
	public ResponseEntity<Response> getQuestion(@RequestParam Long questionId) {
		return serviceImpl.getQuestion(questionId);
	}
	
	@PostMapping("/question/deleteQuestion")
	public ResponseEntity<Response> deleteQuestion(@RequestParam Long questionId) {
		return serviceImpl.deleteQuestion(questionId);
	}
	
}
