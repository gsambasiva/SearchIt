package com.search.SearchIt.unitest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.search.searchit.model.Question;
import com.search.searchit.service.IQuestionService;
import com.search.searchit.util.Response;

@RunWith(MockitoJUnitRunner.Silent.class)
public class QuestionServiceMock {
	
	IQuestionService questionService;
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before Test Method");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("After Test Method");
	}
	
	@Test
	public void test_createQuestion() {
		questionService = mock(IQuestionService.class);
		Question question = new Question();
		question.setQuestion("What is your name?");
		question.setUserId(12l);
		when(questionService.createQuestion(question)).thenReturn(new ResponseEntity<Response>(new Response(Boolean.TRUE, "Question created sucessfully", question), HttpStatus.OK));
		ResponseEntity<Response> response = questionService.createQuestion(question);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	

	@Test
	public void test_updateQuestion() {
		questionService = mock(IQuestionService.class);
		Question question = new Question();
		question.setQuestion("What is our name?");
		question.setUserId(12l);
		question.setId(3l);
		when(questionService.updateQuestion(question)).thenReturn(new ResponseEntity<Response>(new Response(Boolean.TRUE, "Question created sucessfully", question), HttpStatus.OK));
		ResponseEntity<Response> response = questionService.updateQuestion(question);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	public void test_getQuestion() {
		questionService = mock(IQuestionService.class);
		Question question = new Question();
		question.setQuestion("What is our name?");
		question.setUserId(12l);
		when(questionService.getQuestion(3l)).thenReturn(new ResponseEntity<Response>(new Response(Boolean.TRUE, "Question  retrived sucessfully", question), HttpStatus.OK));
		ResponseEntity<Response> response = questionService.getQuestion(3l);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	public void test_deleteQuestion() {
		questionService = mock(IQuestionService.class);
		when(questionService.deleteQuestion(3l)).thenReturn(new ResponseEntity<Response>(new Response(Boolean.TRUE, "Question deleted sucessfully", null), HttpStatus.OK));
		ResponseEntity<Response> response = questionService.deleteQuestion(3l);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	

}
