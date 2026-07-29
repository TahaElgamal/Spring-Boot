package com.spring.bootElgamal.University.Course.Management.System.controller;

import com.spring.bootElgamal.University.Course.Management.System.dto.StudentDto;
import com.spring.bootElgamal.University.Course.Management.System.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    // Create a student
    @PostMapping
    public StudentDto createStudent(@RequestBody StudentDto studentDto) {
        return studentService.createStudent(studentDto);
    }

    // Get all students
    @GetMapping
    public List<StudentDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Get student by ID with courses and instructors
    @GetMapping("/{id}")
    public StudentDto getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    // Register student to course
    @PostMapping("/{studentId}/courses/{courseId}")
    public String registerStudentToCourse(
            @PathVariable Long studentId,
            @PathVariable Long courseId) {

        studentService.registerStudentToCourse(studentId, courseId);

        return "Student registered to course successfully";
    }
}
