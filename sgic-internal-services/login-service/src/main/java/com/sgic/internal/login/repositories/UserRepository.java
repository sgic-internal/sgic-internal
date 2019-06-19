package com.sgic.internal.login.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sgic.internal.login.entities.User;

@Repository
public interface UserRepository  extends JpaRepository<User, String >{

	User getByEmail(String email);   //Get the user by his email address
	
	@Query(value ="FROM User WHERE role =:role")
	List<User>getByRole(@Param("role")String role);  //Get the user by his role
}
