package com.search.searchit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private String comment;

	@Column(name="user_id")
	private Long userId;
	
	@Column(name="question_id")
	private String questionId;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private CommentType commenttype;
	
	@Column(name="reply_comment_id")
	private Long replyCommentId;
	

	
}
