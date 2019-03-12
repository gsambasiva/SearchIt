package com.search.searchit.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.search.searchit.dao.ICustomUser;
import com.search.searchit.model.User;

@Repository
public class CustomUserImpl implements ICustomUser{

	private EntityManager em;

	@Override
	public List<User> getUserByName(String name) {
		CriteriaBuilder cb= em.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> user = cq.from(User.class);
		List<Predicate> predicates = new ArrayList<>();
		if(name != null && name.length() > 0){
			predicates.add(cb.like(user.get("firstName"), "%"+name+"%"));
		}
		cq.where(predicates.toArray(new Predicate[0]));
		return em.createQuery(cq).getResultList();
	}

	@Override
	public User findUserByEmail(String email) {
		CriteriaBuilder cb= em.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> user = cq.from(User.class);
		List<Predicate> predicates = new ArrayList<>();
		if(email != null && email.length() > 0){
			predicates.add(cb.equal(user.get("email"), email));
		}
		cq.where(predicates.toArray(new Predicate[0]));
		return em.createQuery(cq).getSingleResult();
	}

}
