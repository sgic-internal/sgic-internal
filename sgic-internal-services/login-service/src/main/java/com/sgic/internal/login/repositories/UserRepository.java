package com.sgic.internal.login.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgic.internal.login.entities.User;

@Repository
public interface UserRepository  extends JpaRepository<User, String >{

}
