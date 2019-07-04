package com.sgic.internal.configure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.internal.configure.entities.Severity;

public interface SeverityRepo extends JpaRepository<Severity, Long> {

}
