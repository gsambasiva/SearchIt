package com.search.searchit.validation;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.search.searchit.model.BaseEntity;
import com.search.searchit.model.Comment;
import com.search.searchit.model.Question;
import com.search.searchit.model.User;
import com.search.searchit.util.Response;

@Service
public class ValidationHelper {
	
	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	Validator validator = factory.getValidator();
	
	public Response validateUser(User user) {
		return helper(validator.validate(user, IValidationelper.class));
	}
	
	public Response validateQuestion(Question question) {
		return helper(validator.validate(question, IValidationelper.class));
	}
	
	public Response validateComment(Comment comment) {
		return helper(validator.validate(comment, IValidationelper.class));
	}
	public Response helper(Set<ConstraintViolation<BaseEntity>> violations) {
		Set<String> messages = new HashSet<>(violations.size());
		messages.addAll(violations.stream()
		        .map(constraintViolation -> String.format("%s value '%s' %s", constraintViolation.getPropertyPath(),
		                constraintViolation.getInvalidValue(), constraintViolation.getMessage()))
		        .collect(Collectors.toList()));
		if(messages.size()>0) {
			return new Response(Boolean.FALSE, "Validation is Failed", messages);			
		}
		return new Response(Boolean.TRUE, "Validation is sucess", messages);	
	}

}
