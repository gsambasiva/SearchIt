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

import com.search.searchit.model.Comment;
import com.search.searchit.model.CommentType;
import com.search.searchit.service.ICommentService;
import com.search.searchit.util.Response;

@RunWith(MockitoJUnitRunner.Silent.class)
public class CommentServiceMock {
	
	ICommentService commentServoice;
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before Test Method");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("After Test Method");
	}

	@Test
	public void test_createComment() {
		commentServoice = mock(ICommentService.class);
		Comment  comment = new Comment();
		comment.setComment("Sairam");
		comment.setCommenttype(CommentType.ANSWER);
		comment.setQuestionId(3l);
		comment.setUserId(12l);
		when(commentServoice.createComment(comment)).thenReturn(new ResponseEntity<Response>(new Response(Boolean.TRUE, "Comment created sucessfully", comment), HttpStatus.OK));
		ResponseEntity<Response> response = commentServoice.createComment(comment);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	public void test_updateComment() {
		commentServoice = mock(ICommentService.class);
		Comment  comment = new Comment();
		comment.setComment("Sairammm");
		comment.setCommenttype(CommentType.ANSWER);
		comment.setQuestionId(3l);
		comment.setUserId(12l);
		when(commentServoice.updateComment(comment)).thenReturn(new ResponseEntity<Response>(new Response(Boolean.TRUE, "Comment updated sucessfully", comment), HttpStatus.OK));
		ResponseEntity<Response> response = commentServoice.updateComment(comment);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	public void test_getComment() {
		commentServoice = mock(ICommentService.class);
		Comment  comment = new Comment();
		comment.setComment("Sairammm");
		comment.setCommenttype(CommentType.ANSWER);
		comment.setQuestionId(3l);
		comment.setUserId(12l);
		when(commentServoice.getComment(5l)).thenReturn(new ResponseEntity<Response>(new Response(Boolean.TRUE, "Comment retrived sucessfully", comment), HttpStatus.OK));
		ResponseEntity<Response> response = commentServoice.getComment(5l);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	public void test_deleteComment() {
		commentServoice = mock(ICommentService.class);
		when(commentServoice.deleteComment(5l)).thenReturn(new ResponseEntity<Response>(new Response(Boolean.TRUE, "comment deleted sucessfully", null), HttpStatus.OK));
		ResponseEntity<Response> response = commentServoice.deleteComment(5l);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
}
