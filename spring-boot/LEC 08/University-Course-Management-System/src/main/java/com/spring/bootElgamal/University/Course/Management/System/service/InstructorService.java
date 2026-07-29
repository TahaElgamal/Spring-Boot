package com.spring.bootElgamal.University.Course.Management.System.service;

import com.spring.bootElgamal.University.Course.Management.System.dto.InstructorDto;

import java.util.List;

public interface InstructorService {
    InstructorDto createInstructor(InstructorDto instructor);

    List<InstructorDto> getAllInstructors();

    InstructorDto getInstructorById(Long id);
}
