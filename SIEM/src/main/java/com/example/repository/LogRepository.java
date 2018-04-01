package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Log;

public interface LogRepository extends JpaRepository<Log, Long> {

}
