package com.staffms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.staffms.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>{

	Optional<Student> findByEmail(String email);

}
