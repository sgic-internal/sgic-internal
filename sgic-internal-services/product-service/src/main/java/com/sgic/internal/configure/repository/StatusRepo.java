package com.sgic.internal.configure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.internal.configure.entities.Status;

public interface StatusRepo extends JpaRepository<Status, Long> {

}
