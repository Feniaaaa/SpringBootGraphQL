package com.graphql.example.controller;

import com.graphql.example.entities.Course;
import com.graphql.example.entities.Student;
import com.graphql.example.graphql.InputStudent;
import com.graphql.example.repository.StudentRepository;
import com.graphql.example.service.ICourseService;
import com.graphql.example.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @Autowired
    private ICourseService courseService;

    @MutationMapping
    public Student createStudent(@Argument InputStudent inputStudent){

        Course course = courseService.findById(Long.parseLong(inputStudent.getCourseId()));


        Student student = new Student();
        student.setName(inputStudent.getName());
        student.setLastName(inputStudent.getLastName());
        student.setAge(inputStudent.getAge());
        student.setCourse(course);

        studentService.save(student);
        return student;
    }

    @QueryMapping(name = "findStudentById")
    public Student findById(@Argument(name = "studentId") String id){
        Long StudentId= Long.parseLong(id);

        return studentService.findById(StudentId);
    }

    @QueryMapping(name = "findAllStudent")
    public List<Student> findAll(){
        return studentService.findAll();
    }

    @MutationMapping
    public String deleteStudentById(@Argument(name = "studentId") String id){
        studentService.Delete(Long.parseLong(id));
        return "El estudiante con el id "+ id +" a sido eliminado";
    }
}
