package com.graphql.example.graphql;

import lombok.Data;

@Data
public class InputStudent {
    private Long id;
    private String name;
    private String lastName;
    private int age;
    private String courseId;
}
