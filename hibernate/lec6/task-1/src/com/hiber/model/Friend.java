package com.hiber.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Friends")
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    @ManyToMany(mappedBy = "friends")
    private List<User> users;

    public Friend() {
    }
}
