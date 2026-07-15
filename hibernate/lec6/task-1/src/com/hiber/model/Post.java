package com.hiber.model;

import javax.persistence.*;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String header;

    private String content;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private User user;
}
