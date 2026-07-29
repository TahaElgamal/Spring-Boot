package com.spring.bootElgamal.University.Course.Management.System.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private Long id;
    private String name;
    private String email;

    private List<CourseDto> courses;

    public StudentDto(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
