package com.spring.bootElgamal.University.Course.Management.System.repo;

import com.spring.bootElgamal.University.Course.Management.System.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepo extends JpaRepository<Instructor,Long> {
}
