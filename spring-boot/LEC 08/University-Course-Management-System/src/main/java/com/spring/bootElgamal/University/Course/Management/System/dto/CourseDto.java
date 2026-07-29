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
public class CourseDto {
    private Long id;
    private String title;
    private String description;

    private InstructorBasicDto instructor;

    private List<StudentBasicDto> students;

    public CourseDto(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }
}
