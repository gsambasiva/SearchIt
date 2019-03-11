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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.search.searchit.validation.IValidationelper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@Size(min=2, message="Name should have atleast 2 characters")
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	@Size(min=2, message="Name should have atleast 2 characters")
	private String lastName;
	
	@Column(name="email",unique=true)
	@Email
	private String email;
	
	@Column(name="password")
	@NotNull
	public String password;
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name = "user_id")
	private List<Question> questions = new ArrayList<Question>();

}
