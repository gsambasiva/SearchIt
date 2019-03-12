package com.search.searchit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.search.searchit.model.User;

@Repository
public interface IUserDao extends JpaRepository<User, Long>, ICustomUser{

}
