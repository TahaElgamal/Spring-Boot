package com.spring.bootElgamal.University.Course.Management.System.service;

import com.spring.bootElgamal.University.Course.Management.System.dto.CourseDto;
import com.spring.bootElgamal.University.Course.Management.System.dto.InstructorDto;
import com.spring.bootElgamal.University.Course.Management.System.dto.StudentBasicDto;
import com.spring.bootElgamal.University.Course.Management.System.model.Instructor;
import com.spring.bootElgamal.University.Course.Management.System.repo.InstructorRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepo instructorRepo;

    public InstructorServiceImpl(InstructorRepo instructorRepo) {
        this.instructorRepo = instructorRepo;
    }

    @Override
    public InstructorDto createInstructor(InstructorDto instructorDto) {

        Instructor instructor = new Instructor();

        instructor.setName(instructorDto.getName());
        instructor.setEmail(instructorDto.getEmail());

        Instructor savedInstructor = instructorRepo.save(instructor);

        return new InstructorDto(savedInstructor.getId(), savedInstructor.getName(), savedInstructor.getEmail());
    }



    @Override
    public List<InstructorDto> getAllInstructors() {

        return instructorRepo.findAll()
                .stream()
                .map(instructor -> new InstructorDto(instructor.getId(), instructor.getName(), instructor.getEmail()))
                .collect(Collectors.toList());

}

    @Override
    public InstructorDto getInstructorById(Long id) {

        Instructor instructor = instructorRepo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Instructor not found with id: " + id));

        InstructorDto instructorDto = new InstructorDto();

        instructorDto.setId(instructor.getId());
        instructorDto.setName(instructor.getName());
        instructorDto.setEmail(instructor.getEmail());

        List<CourseDto> courses = instructor.getCourses()
                .stream()
                .map(course -> {

                    CourseDto courseDto = new CourseDto();

                    courseDto.setId(course.getId());
                    courseDto.setTitle(course.getTitle());
                    courseDto.setDescription(course.getDescription());

                    List<StudentBasicDto> students = course.getStudents()
                            .stream()
                            .map(student -> {

                                StudentBasicDto studentDto = new StudentBasicDto();

                                studentDto.setId(student.getId());
                                studentDto.setName(student.getName());
                                studentDto.setEmail(student.getEmail());

                                return studentDto;

                            })
                            .collect(Collectors.toList());

                    courseDto.setStudents(students);

                    return courseDto;

                })
                .collect(Collectors.toList());

        instructorDto.setCourses(courses);

        return instructorDto;
    }
}
