package com.p1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.p1.dao.StaffDao;
import com.p1.entity.Staff;

@Service
public class StaffService {
	
	@Autowired
	private StaffDao staffDao;
	
	public boolean saveStaff(Staff staff) {
		Staff savedStaff= staffDao.saveStaff(staff);
		return savedStaff!=null;
	}

}
