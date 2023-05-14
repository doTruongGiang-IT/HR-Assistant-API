package com.example.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.entity.Interviewer;


@Repository
public interface InterviewerRepository extends JpaRepository<Interviewer, Long> {

}