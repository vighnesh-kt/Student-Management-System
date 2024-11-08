package com.p1.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.p1.dao.StaffDao;
import com.p1.entity.Staff;

@Service
public class StaffService {
	
	@Autowired
	private StaffDao staffDao;
	
	public boolean saveStaff(Staff staff) {
		Optional<Staff> opt = staffDao.findByEmail((staff.getEmail()));
		if (opt.isPresent()) {
			return false;
		} else {
			staffDao.saveStaff(staff);
			return true;
		}
		
	}

	public boolean getStaff(Staff staff) {
		// TODO Auto-generated method stub
		Optional<Staff>opt=staffDao.findByEmail(staff.getEmail());
		if(opt.isPresent()) {
			if(opt.get().getPassword().equals(staff.getPassword())) {
				return true;
			}
			return false;
		}
		return false;
	}
	
	
}
