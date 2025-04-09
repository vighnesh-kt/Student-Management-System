package com.staffms.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.staffms.entity.Student;
import com.staffms.repository.StudentRepository;

@Repository
public class StudentDao {
	
	@Autowired
	private StudentRepository studentRepository;

	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
		
	}
	

	public Optional<Student> findById(Integer sid) {
		// TODO Auto-generated method stub
		return studentRepository.findById(sid);
	}

	public Optional<Student> findByEmail(String email) {
		// TODO Auto-generated method stub
		return studentRepository.findByEmail(email);
	}

	public void deleteById(Integer sid) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(sid);;
	}

}
