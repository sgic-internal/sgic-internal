package com.sgic.internal.configure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.internal.configure.entities.Type;

public interface TypeRepo extends JpaRepository<Type, Long> {

}
