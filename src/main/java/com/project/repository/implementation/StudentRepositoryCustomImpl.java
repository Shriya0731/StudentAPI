package com.project.repository.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.project.model.Student;
import com.project.repository.StudentRepositoryCustom;

public class StudentRepositoryCustomImpl implements StudentRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Student> findByEmail(String email) {
        String queryString = "SELECT * FROM Student WHERE email = '" + email + "'";
        System.out.println(queryString);
        System.out.println(entityManager.createNativeQuery(queryString, Student.class).getResultList());
        return entityManager.createNativeQuery(queryString, Student.class).getResultList();
    }
}
