package com.spring.bootElgamal.University.Course.Management.System.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students= new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;
}
