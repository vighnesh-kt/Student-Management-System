package com.staffms.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.staffms.entity.Staff;
import com.staffms.repository.StaffRepository;

@Repository
public class StaffDao {
	
	@Autowired
	private StaffRepository staffRepository;

	public Staff saveStaff(Staff staff) {
		// TODO Auto-generated method stub
		return staffRepository.save(staff);
		
	}

	public Optional<Staff> findByEmail(String email) {
		// TODO Auto-generated method stub
		return staffRepository.findByEmail(email);
	}

}
