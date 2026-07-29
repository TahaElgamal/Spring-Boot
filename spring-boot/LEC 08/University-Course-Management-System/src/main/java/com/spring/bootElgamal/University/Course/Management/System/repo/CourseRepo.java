package com.spring.bootElgamal.University.Course.Management.System.repo;

import com.spring.bootElgamal.University.Course.Management.System.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Course,Long> {
}
