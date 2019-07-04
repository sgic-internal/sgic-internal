package com.sgic.internal.configure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.internal.configure.entities.Priority;

public interface PriorityRepo extends JpaRepository<Priority, Long> {

}
