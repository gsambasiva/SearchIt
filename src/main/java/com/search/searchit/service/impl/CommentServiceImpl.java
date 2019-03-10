package com.search.searchit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.search.searchit.dao.ICommentDao;
import com.search.searchit.model.Comment;
import com.search.searchit.service.ICommentService;
import com.search.searchit.util.Response;

@Service
public class CommentServiceImpl implements ICommentService{
	@Autowired ICommentDao commentDao;

	@Override
	public ResponseEntity<Response> createComment(Comment comment) {
		Comment createdComment = commentDao.save(comment);
		return new ResponseEntity<Response>(new Response(Boolean.TRUE, "Comment created sucessfully", createdComment), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Response> updateComment(Comment comment) {
		Comment updatedComment  = commentDao.save(comment);
		return new ResponseEntity<Response>(new Response(Boolean.TRUE, "Comment updated sucessfully", updatedComment), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Response> getComment(Long commentId) {
		Comment retrivedComment = commentDao.getOne(commentId);
		return new ResponseEntity<Response>(new Response(Boolean.TRUE, "Comment retrived sucessfully", retrivedComment), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Response> deleteComment(Long commentId) {
		commentDao.deleteById(commentId);
		return new ResponseEntity<Response>(new Response(Boolean.TRUE, "comment deleted sucessfully", null), HttpStatus.OK); 
	}
	

}
