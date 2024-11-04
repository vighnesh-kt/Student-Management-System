package com.p1.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.p1.entity.Staff;
import com.p1.repository.StaffRepository;

@Repository
public class StaffDao {
	
	@Autowired
	private StaffRepository staffRepository;

	public Staff saveStaff(Staff staff) {
		// TODO Auto-generated method stub
		return staffRepository.save(staff);
		
	}

}
