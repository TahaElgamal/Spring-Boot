package com.hiber.model;

import javax.persistence.*;

@Entity
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String address;

    private String phone;

    @OneToOne
    private User user;

    public UserDetails() {
    }
}
