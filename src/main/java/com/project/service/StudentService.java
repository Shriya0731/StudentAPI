package com.project.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.model.Student;
import com.project.repository.StudentRepository;


@Service
public class StudentService {
	@Autowired
	private StudentRepository repository;
	
	public List<Student> getStudents(){
        return (List<Student>) repository.findAll();
    }
	public Student createStudent(Student student) {
		return repository.save(student);
		
	}
//	public org.springframework.http.ResponseEntity<?> loginStudent(Student studentdata){
//        Student student = repository.findByemail(studentdata.getEmail());
//		
//		if(student.getpassword().equals(student.getpassword())) {
//			return org.springframework.http.ResponseEntity.ok(student);
//		}
//		return (org.springframework.http.ResponseEntity<?>) org.springframework.http.ResponseEntity.internalServerError();
//	}
	public org.springframework.http.ResponseEntity<?> loginStudent(Student studentdata){
		System.out.println(studentdata.getEmail());
		System.out.println(studentdata.getpassword());
        List<Student> student = repository.findByEmail(studentdata.getEmail());
		if(student==null) {
			return org.springframework.http.ResponseEntity.ok(student);

		}
		System.out.println(student.get(0).getpassword());

		if(student.get(0).getpassword().equals(studentdata.getpassword())) {
			return org.springframework.http.ResponseEntity.ok(student);
		}
		else {
			return org.springframework.http.ResponseEntity.ok("Password does not match");
		}
	}
}
