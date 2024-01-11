package com.graphql.example.service;

import com.graphql.example.entities.Course;
import com.graphql.example.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService{

    @Autowired
    private CourseRepository courseRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Course> findAll() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Course findById(Long id) {
        return courseRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public void save(Course student) {
        courseRepository.save(student);
    }

    @Override
    @Transactional
    public void Delete(Long id) {
        courseRepository.deleteById(id);
    }

}
