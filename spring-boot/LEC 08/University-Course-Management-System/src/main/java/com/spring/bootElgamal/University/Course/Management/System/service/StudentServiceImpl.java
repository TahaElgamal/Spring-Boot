package com.spring.bootElgamal.University.Course.Management.System.service;

import com.spring.bootElgamal.University.Course.Management.System.dto.CourseDto;
import com.spring.bootElgamal.University.Course.Management.System.dto.InstructorBasicDto;
import com.spring.bootElgamal.University.Course.Management.System.dto.StudentDto;
import com.spring.bootElgamal.University.Course.Management.System.model.Course;
import com.spring.bootElgamal.University.Course.Management.System.model.Student;
import com.spring.bootElgamal.University.Course.Management.System.repo.CourseRepo;
import com.spring.bootElgamal.University.Course.Management.System.repo.StudentRepo;
import jakarta.transaction.SystemException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
@Service
public class StudentServiceImpl implements StudentService{
    private final StudentRepo studentRepo;
    private final CourseRepo courseRepo;

    public StudentServiceImpl(StudentRepo studentRepo, CourseRepo courseRepo) {
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
    }

    @Override
    public StudentDto createStudent(StudentDto studentDto) {

        Student student = new Student();

        student.setName(studentDto.getName());
        student.setEmail(studentDto.getEmail());

        Student savedStudent = studentRepo.save(student);

        return new StudentDto(savedStudent.getId(), savedStudent.getName(), savedStudent.getEmail());

    }

    @Override
    public List<StudentDto> getAllStudents() {

        return studentRepo.findAll()
                .stream()
                .map(student -> new StudentDto(student.getId(), student.getName(), student.getEmail()))
                .collect(Collectors.toList());

    }

    @Override
    public StudentDto getStudentById(Long id) {

        Student student = studentRepo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Student not found with id: " + id));

        StudentDto studentDto = new StudentDto();

        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setEmail(student.getEmail());

        List<CourseDto> courses = student.getCourses()
                .stream()
                .map(course -> {

                    CourseDto courseDto = new CourseDto();

                    courseDto.setId(course.getId());
                    courseDto.setTitle(course.getTitle());
                    courseDto.setDescription(course.getDescription());

                    if (course.getInstructor() != null) {

                        InstructorBasicDto instructorDto = new InstructorBasicDto();

                        instructorDto.setId(course.getInstructor().getId());
                        instructorDto.setName(course.getInstructor().getName());
                        instructorDto.setEmail(course.getInstructor().getEmail());

                        courseDto.setInstructor(instructorDto);
                    }

                    return courseDto;

                })
                .collect(Collectors.toList());
        studentDto.setCourses(courses);

        return studentDto;
    }

    @Override
    public void registerStudentToCourse(Long studentId, Long courseId) {

        Student student = studentRepo.findById(studentId)
                .orElseThrow(() ->
                        new RuntimeException("Student not found with id: " + studentId));

        Course course = courseRepo.findById(courseId)
                .orElseThrow(() ->
                        new RuntimeException("Course not found with id: " + courseId));

        student.getCourses().add(course);

        studentRepo.save(student);
    }
}
