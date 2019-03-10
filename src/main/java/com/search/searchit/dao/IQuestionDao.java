package com.search.searchit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.search.searchit.model.Question;

@Repository
public interface IQuestionDao extends JpaRepository<Question, Long> {
	/*public ResponseEntity<Response> askQuestion();*/

}
