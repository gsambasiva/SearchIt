package com.search.searchit.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_question")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE)
private Long Id;
@Column(name="question")
private String question;
@OneToMany
private Set<User> user = new HashSet<User>();
}
