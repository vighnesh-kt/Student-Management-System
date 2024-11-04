package com.p1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="student_info")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer sid;
	
	String name;
	
	String email;
	
	long phone;

}
