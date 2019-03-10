package com.search.searchit.service;

import org.springframework.http.ResponseEntity;

import com.search.searchit.model.Question;
import com.search.searchit.util.Response;

public interface IQuestionService {
	public ResponseEntity<Response> createQuestion(Question question);
	public ResponseEntity<Response> updateQuestion(Question question);
	public ResponseEntity<Response> getQuestion(Long id);
	public ResponseEntity<Response> deleteQuestion(Long questionId);
}
