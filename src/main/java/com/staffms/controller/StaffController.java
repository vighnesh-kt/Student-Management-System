package com.staffms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;

import com.staffms.dto.EmailDto;
import com.staffms.entity.Staff;
import com.staffms.entity.Student;
import com.staffms.service.EmailService;
import com.staffms.service.StaffService;
import com.staffms.service.StudentService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class StaffController {

	@Autowired
	private StaffService staffService;

	@Autowired
	private StudentService studentService;

	@Autowired
	private EmailService emailService;

//	To ensure a smooth and effective form handling process, it's best practice to:
//	Always send an empty instance of the object you intend to bind data to when rendering 
//	the form. This allows for proper binding and makes it easier to manage validation and 
//	error messages.
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
			mv.addObject("msg", "Registered Successfully");
		} else {
			mv.setViewName("login");
			mv.addObject("msg", "User Already Registered");
		}
		return mv;
	}

	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}

	@PostMapping("/login")
	public ModelAndView login(Staff staff) {
		boolean isPresent = staffService.getStaff(staff);
		ModelAndView mv = new ModelAndView();
		if (isPresent) {
			List<Student> students = studentService.findAll();
			mv.setViewName("home");
			mv.addObject("students", students);
			mv.addObject("msg", "Welcome to Home Page");
		} else {
			mv.setViewName("login");
			mv.addObject("msg", "Login Failed: User Not Found");
		}

		return mv;
	}

	@GetMapping("/home")
	public ModelAndView home() {
		List<Student> students = studentService.findAll();
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("students", students);
		return mv;
	}

	@GetMapping("/add")
	public ModelAndView addStudents() {
		ModelAndView mv = new ModelAndView("add");
		mv.addObject("student", new Student());
		return mv;
	}

	@PostMapping("/save")
	public ModelAndView saveStudent(Student student) {
		Student saveStudent = studentService.saveStudent(student);
		ModelAndView mv = new ModelAndView();
		if (saveStudent!=null) {
			List<Student> students = studentService.findAll();
			mv.setViewName("home");
			mv.addObject("students", students);
			mv.addObject("msg", "Student added successfully");
		} else {
			mv.setViewName("add");
			mv.addObject("msg", "Failed to add student");
		}
		return mv;
	}

	@GetMapping("/email")
	public ModelAndView displayEmail() {
		ModelAndView mv = new ModelAndView("email");
		mv.addObject("email", new EmailDto());
		return mv;
	}

	@PostMapping("/send")
	public ModelAndView sendEmail(EmailDto email) {
		// TODO: process POST request
		emailService.send(email);
		ModelAndView mv = new ModelAndView("home");
		List<Student> all = studentService.findAll();
		mv.addObject("students", all);
		mv.addObject("msg", "Mail sent");
		return mv;
	}

	@GetMapping("/update")
	public ModelAndView updateStudent(@RequestParam Integer sid) {
		Student student = studentService.findById(sid);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("update");
		mv.addObject("stu", student);
		return mv;
	}

	@PostMapping("/update")
	public ModelAndView postMethodName(Student student) {
		Student std = studentService.saveStudent(student);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		mv.addObject("msg", "Student Updated");
		List<Student> all = studentService.findAll();
		mv.addObject("students", all);
		return mv;

	}
	
	@GetMapping("/delete")
	public ModelAndView deleteStudent(Integer sid) {
		studentService.deleteById(sid);
		ModelAndView mv= new ModelAndView();
		List<Student> all = studentService.findAll();//everytime reurning list to homepage
		mv.addObject("students", all);
		mv.addObject("msg","Student Deleted");
		mv.setViewName("home");
		return mv;
	}
	

}
