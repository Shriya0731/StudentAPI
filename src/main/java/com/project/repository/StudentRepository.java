package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.model.Student;

public interface StudentRepository extends JpaRepository<Student,String>, StudentRepositoryCustom{

////	Student findByemail(String email);
//	@Query(value = "SELECT * FROM Student WHERE email = ?1", nativeQuery = true)
//    Student findByEmail(String email);
}
