package com.search.searchit.model;

import java.util.ArrayList;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.search.searchit.validation.IValidationelper;

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

	@Column(name="question")
	@Size(min=10, message="Name should have atleast 10 characters")
	private String question;

	@Column(name="user_id")
	@NotNull
	private Long userId;
	
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name = "question_id")
	private List<Comment> comments = new ArrayList<Comment>();
}
