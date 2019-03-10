package com.search.searchit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.search.searchit.dao.IQuestionDao;
import com.search.searchit.model.Question;
import com.search.searchit.service.IQuestionService;
import com.search.searchit.util.Response;

@Service
public class QuestionServiceImpl implements IQuestionService {
@Autowired IQuestionDao questionDao;
	@Override
	public ResponseEntity<Response> createQuestion(Question question) {
		Question createdQuestion = questionDao.save(question);
		return new ResponseEntity<Response>(new Response(Boolean.TRUE, "Question created sucessfully", createdQuestion), HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<Response> updateQuestion(Question question) {
		Question updateQuestion = questionDao.save(question);
		return new ResponseEntity<Response>(new Response(Boolean.TRUE, "Question updated sucessfully", updateQuestion), HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<Response> getQuestion(Long id) {
		Question retrivedQuestion = questionDao.getOne(id);
		return new ResponseEntity<Response>(new Response(Boolean.TRUE, "Question  retrived sucessfully", retrivedQuestion), HttpStatus.OK);	
	}
	
	@Override
	public ResponseEntity<Response> deleteQuestion(Long questionId) {
		questionDao.deleteById(questionId);
		return new ResponseEntity<Response>(new Response(Boolean.TRUE, "Question deleted sucessfully", null), HttpStatus.OK);
	}
}
