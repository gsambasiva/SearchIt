package com.search.searchit.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Question")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question extends BaseEntity{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;

	@Column(name="question" )
	private String question;

	@Column(name="user_id")
	private Long userId;
	
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name = "question_id")
	private List<Comment> comments;
}
