package com.project.repository;

import java.util.List;

import com.project.model.Student;

public interface StudentRepositoryCustom {
	List<Student> findByEmail(String email);
}
