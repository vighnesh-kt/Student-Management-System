package com.staffms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.staffms.dao.StudentDao;
import com.staffms.entity.Student;

@Service
public class StudentService {

	@Autowired
	private StudentDao studentDao;

	public List<Student> findAll() {
		List<Student> students = studentDao.findAll();
		return students;
	}

	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		Optional<Student> opt = studentDao.findByEmail(student.getEmail());
		return studentDao.saveStudent(student);

	}

	public Student findById(Integer sid) {
		// TODO Auto-generated method stub
		Optional<Student> opt = studentDao.findById(sid);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			return null;
		}
	}

	public void deleteById(Integer sid) {
		// TODO Auto-generated method stub
		studentDao.deleteById(sid);
		
	}

}
