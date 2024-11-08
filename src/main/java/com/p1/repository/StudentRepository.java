package com.p1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.p1.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>{

	Optional<Student> findByEmail(String email);

}
