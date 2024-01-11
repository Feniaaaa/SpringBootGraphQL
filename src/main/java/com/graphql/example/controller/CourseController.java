package com.graphql.example.controller;

import com.graphql.example.entities.Course;
import com.graphql.example.entities.Student;
import com.graphql.example.graphql.InputCourse;
import com.graphql.example.graphql.InputStudent;
import com.graphql.example.service.ICourseService;
import com.graphql.example.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CourseController {

    @Autowired
    private ICourseService courseService;

    @Autowired
    private IStudentService studentService;


    @MutationMapping
    public Course createCourse(@Argument InputCourse inputCourse){

        Course course = new Course();
        course.setName(inputCourse.getName());
        course.setCategory(inputCourse.getCategory());
        course.setTeacher(inputCourse.getTeacher());

        courseService.save(course);
        return course;
    }
    @QueryMapping(name = "findCourseById")
    public Course findById(@Argument(name = "courseId") String id){
        Long courseId= Long.parseLong(id);

        return courseService.findById(courseId);
    }

    @QueryMapping(name = "findAllCourse")
    public List<Course> findAll(){
        return courseService.findAll();
    }

    @MutationMapping
    public String deleteCourseById(@Argument(name = "courseId") String id){
        courseService.Delete(Long.parseLong(id));
        return "El curso con el id "+ id +" a sido eliminado";
    }
}
