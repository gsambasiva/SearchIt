package com.search.searchit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.search.searchit.model.Comment;

@Repository
public interface ICommentDao extends JpaRepository<Comment, Long> {

}
