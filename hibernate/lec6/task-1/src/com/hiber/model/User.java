package com.hiber.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "UserTabl")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int age;

    @OneToOne(mappedBy = "user",cascade = CascadeType.PERSIST)
    private UserDetails userDetails;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Friend> friends;

    @OneToMany(mappedBy = "user",cascade = CascadeType.PERSIST)
    private List<Post> posts;

    public User() {
    }
}
