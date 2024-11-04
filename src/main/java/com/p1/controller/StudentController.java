package com.p1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;

import com.p1.entity.Staff;
import com.p1.service.StaffService;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class StudentController {

	@Autowired
	private StaffService staffService;

	@GetMapping("/")
	public ModelAndView welcome() {
		ModelAndView mv = new ModelAndView("register");
		mv.addObject("staff", new Staff());
		return mv;
	}

	@PostMapping("/register")
	public ModelAndView registerStaff(Staff staff) {
		boolean isRegistered = staffService.saveStaff(staff);
		ModelAndView mv = new ModelAndView();
		if (isRegistered) {
			mv.setViewName("login");
			mv.addObject("registerSuccess", "Registered Successfully");
		} else {
			mv.setViewName("register");
			mv.addObject("registerFailed", "User Already Registered");
		}
		return mv;
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	

}
