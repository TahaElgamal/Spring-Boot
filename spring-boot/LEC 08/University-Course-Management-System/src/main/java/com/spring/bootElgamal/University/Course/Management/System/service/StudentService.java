package com.spring.bootElgamal.University.Course.Management.System.service;

import com.spring.bootElgamal.University.Course.Management.System.dto.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto createStudent(StudentDto student);

    List<StudentDto> getAllStudents();

    StudentDto getStudentById(Long id);

    void registerStudentToCourse(Long studentId, Long courseId);
}
