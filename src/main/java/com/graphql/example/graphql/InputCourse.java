package com.graphql.example.graphql;

import lombok.Data;

@Data
public class InputCourse {
    private Long id;
    private String name;
    private String category;
    private String teacher;
}
