package com.spring.bootElgamal.University.Course.Management.System.service;

import com.spring.bootElgamal.University.Course.Management.System.dto.CourseDto;

import java.util.List;

public interface CourseService {
    CourseDto createCourse(CourseDto course);

    List<CourseDto> getAllCourses();

    CourseDto getCourseById(Long id);

    void assignInstructor(Long courseId, Long instructorId);


}
