package com.project.Controller;


import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Student;
import com.project.service.StudentService;



@CrossOrigin("https://localhost:4200/")


@RestController
@RequestMapping("/api/v1/")
public class StudentController {
	
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	@CrossOrigin("https://localhost:4200/register")
	@PostMapping("/students")
	public Student createStudent(@RequestBody Student student) {
		return studentService.createStudent(student);

	}
	
	@CrossOrigin("https://localhost:4200/")

	
	@PostMapping("/loginstudent")
	public org.springframework.http.ResponseEntity<?> loginStudent(@RequestBody Student studentdata){
	    return studentService.loginStudent(studentdata);
	}
	
	
	// build get all students REST API
	@GetMapping("/students")
	public List<Student> getAllstudents(){
		return studentService.getStudents();
	}

}