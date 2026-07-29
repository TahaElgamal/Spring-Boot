package com.spring.bootElgamal.University.Course.Management.System.controller;

import com.spring.bootElgamal.University.Course.Management.System.dto.CourseDto;
import com.spring.bootElgamal.University.Course.Management.System.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    // Create a course
    @PostMapping
    public CourseDto createCourse(@RequestBody CourseDto courseDto) {
        return courseService.createCourse(courseDto);
    }

    // Get all courses
    @GetMapping
    public List<CourseDto> getAllCourses() {
        return courseService.getAllCourses();
    }

    // Get course by ID with instructor and students
    @GetMapping("/{id}")
    public CourseDto getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    // Assign instructor to course
    @PutMapping("/{courseId}/instructor/{instructorId}")
    public String assignInstructor(
            @PathVariable Long courseId,
            @PathVariable Long instructorId) {

        courseService.assignInstructor(courseId, instructorId);

        return "Instructor assigned to course successfully";
    }
}
