package com.graphql.example.service;

import com.graphql.example.entities.Course;
import com.graphql.example.entities.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    Student findById(Long id);
    void save(Student student);
    void Delete(Long id);
}
