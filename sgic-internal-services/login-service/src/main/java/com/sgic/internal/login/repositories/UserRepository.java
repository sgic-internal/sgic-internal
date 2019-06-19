package com.sgic.internal.login.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgic.internal.login.entities.User;

@Repository
public interface UserRepository  extends JpaRepository<User, String >{

	User getByEmail(String email);   //Get the user by his email address
	User getByRole(String role);   //Get the user by his role
}
