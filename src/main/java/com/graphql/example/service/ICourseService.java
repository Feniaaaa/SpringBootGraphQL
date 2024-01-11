package com.graphql.example.service;

import com.graphql.example.entities.Course;
import com.graphql.example.entities.Student;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ICourseService {
    List<Course> findAll();
    Course findById(Long id);
    void save(Course course);
    void Delete(Long id);

}
