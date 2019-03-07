package com.search.searchit.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_comment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long Id;
	@Column(name="comment")
	private String comment;
	@OneToMany
	private Set<User> user = new HashSet<User>();
	@OneToMany
	private Set<Question> question  = new HashSet<Question>();
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private CommentType commenttype;
}
