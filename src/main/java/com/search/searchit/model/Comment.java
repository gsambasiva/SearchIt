package com.search.searchit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.search.searchit.validation.IValidationelper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="comment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment extends BaseEntity{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;

	@Column(name="comment")
	@Size(min=10, message="Name should have atleast 10 characters")
	private String comment;

	@Column(name="user_id")
	@NotNull
	private Long userId;
	
	@Column(name="question_id")
	@NotNull
	private Long questionId;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	@NotNull
	private CommentType commenttype;
	
	@Column(name="reply_comment_id")
	private Long replyCommentId;
	

	
}
