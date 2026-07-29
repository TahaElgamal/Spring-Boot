package com.spring.bootElgamal.University.Course.Management.System.controller;

import com.spring.bootElgamal.University.Course.Management.System.dto.InstructorDto;
import com.spring.bootElgamal.University.Course.Management.System.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructors")
@RequiredArgsConstructor
public class InstructorController {

    private final InstructorService instructorService;

    // Create an instructor
    @PostMapping
    public InstructorDto createInstructor(
            @RequestBody InstructorDto instructorDto) {

        return instructorService.createInstructor(instructorDto);
    }

    // Get all instructors
    @GetMapping
    public List<InstructorDto> getAllInstructors() {
        return instructorService.getAllInstructors();
    }

    // Get instructor by ID with courses and enrolled students
    @GetMapping("/{id}")
    public InstructorDto getInstructorById(@PathVariable Long id) {
        return instructorService.getInstructorById(id);
    }
}
