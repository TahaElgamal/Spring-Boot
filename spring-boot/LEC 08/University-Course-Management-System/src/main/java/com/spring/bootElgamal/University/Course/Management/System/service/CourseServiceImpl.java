package com.spring.bootElgamal.University.Course.Management.System.service;

import com.spring.bootElgamal.University.Course.Management.System.dto.CourseDto;
import com.spring.bootElgamal.University.Course.Management.System.dto.InstructorBasicDto;
import com.spring.bootElgamal.University.Course.Management.System.dto.StudentBasicDto;
import com.spring.bootElgamal.University.Course.Management.System.model.Course;
import com.spring.bootElgamal.University.Course.Management.System.model.Instructor;
import com.spring.bootElgamal.University.Course.Management.System.repo.CourseRepo;
import com.spring.bootElgamal.University.Course.Management.System.repo.InstructorRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService{

    private final CourseRepo courseRepo;
    private final InstructorRepo instructorRepo;

    public CourseServiceImpl(CourseRepo courseRepo, InstructorRepo instructorRepo) {
        this.courseRepo = courseRepo;
        this.instructorRepo = instructorRepo;
    }

    @Override
    public CourseDto createCourse(CourseDto courseDto) {

        Course course = new Course();

        course.setTitle(courseDto.getTitle());
        course.setDescription(courseDto.getDescription());

        Course savedCourse = courseRepo.save(course);

        return new CourseDto(savedCourse.getId(), savedCourse.getTitle(), savedCourse.getDescription());
    }

    @Override
    public List<CourseDto> getAllCourses() {

        return courseRepo.findAll()
                .stream()
                .map(course -> new CourseDto(course.getId(), course.getTitle(), course.getDescription()))
                .collect(Collectors.toList());
    }

    @Override
    public CourseDto getCourseById(Long id) {
        Course course = courseRepo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Course not found with id: " + id));

        CourseDto courseDto = new CourseDto();

        courseDto.setId(course.getId());
        courseDto.setTitle(course.getTitle());
        courseDto.setDescription(course.getDescription());

        // Instructor
        if (course.getInstructor() != null) {

            InstructorBasicDto instructorDto = new InstructorBasicDto();

            instructorDto.setId(course.getInstructor().getId());
            instructorDto.setName(course.getInstructor().getName());
            instructorDto.setEmail(course.getInstructor().getEmail());

            courseDto.setInstructor(instructorDto);
        }

        // Students
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
    }

    @Override
    public void assignInstructor(Long courseId, Long instructorId) {

        Course course = courseRepo.findById(courseId)
                .orElseThrow(() ->
                        new RuntimeException("Course not found with id: " + courseId));

        Instructor instructor = instructorRepo.findById(instructorId)
                .orElseThrow(() ->
                        new RuntimeException("Instructor not found with id: " + instructorId));

        course.setInstructor(instructor);

        courseRepo.save(course);
    }
}
