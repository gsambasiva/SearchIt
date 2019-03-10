package com.search.searchit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.search.searchit.model.Question;
import com.search.searchit.service.impl.QuestionServiceImpl;
import com.search.searchit.util.Response;

@RestController
public class QestionController {
	@Autowired QuestionServiceImpl serviceImpl;
	
	@PostMapping("/question/askQuestion")
	public ResponseEntity<Response> askQuestion(@RequestBody Question question) {
		return serviceImpl.createQuestion(question);
	}
	
	@PostMapping("/question/updateQuestion")
	public ResponseEntity<Response> updateQuestion(@RequestBody Question question) {
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
