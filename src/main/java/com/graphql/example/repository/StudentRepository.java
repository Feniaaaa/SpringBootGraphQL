package com.graphql.example.repository;

import com.graphql.example.entities.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository <Student, Long> {
}
