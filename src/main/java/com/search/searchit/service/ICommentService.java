package com.search.searchit.service;

import org.springframework.http.ResponseEntity;

import com.search.searchit.model.Comment;
import com.search.searchit.util.Response;

public interface ICommentService {
	public ResponseEntity<Response> createComment(Comment comment);
	public ResponseEntity<Response> updateComment(Comment comment);
	public ResponseEntity<Response> getComment(Long commentId);
	public ResponseEntity<Response> deleteComment(Long commentId);
}
