package com.search.searchit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.search.searchit.model.Comment;
import com.search.searchit.service.impl.CommentServiceImpl;
import com.search.searchit.util.Response;

@RestController
public class CommentController {
	
	@Autowired CommentServiceImpl commentService;
	
	@PostMapping("/comment/create")
	public ResponseEntity<Response> createComment(@RequestBody Comment comment) {
		return commentService.createComment(comment);
	}

	@PostMapping("/comment/update")
	public ResponseEntity<Response> updateComment(@RequestBody Comment comment) {
		return commentService.updateComment(comment);
	}

	@PostMapping("/comment/getComment")
	public ResponseEntity<Response> getComment(@RequestParam Long commentId) {
		return commentService.getComment(commentId);
	}

	@PostMapping("/comment/delete")
	public ResponseEntity<Response> deleteComment(@RequestParam Long commentId) {
		return commentService.deleteComment(commentId);
	}
}
