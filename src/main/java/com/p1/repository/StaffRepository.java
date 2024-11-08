package com.p1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.p1.entity.Staff;

public interface StaffRepository extends JpaRepository<Staff, Integer>{

	Optional<Staff> findByEmail(String email);

}
