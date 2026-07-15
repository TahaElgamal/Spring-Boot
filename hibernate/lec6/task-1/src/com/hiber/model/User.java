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

    @OneToOne(mappedBy = "user",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    private UserDetails userDetails;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Friend> friends;

    @OneToMany(mappedBy = "user",cascade = CascadeType.PERSIST)
    private List<Post> posts;

    public User() {
    }

    public User(String name, int age, UserDetails userDetails, List<Friend> friends, List<Post> posts) {
        this.name = name;
        this.age = age;
        this.userDetails = userDetails;
        this.friends = friends;
        this.posts = posts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public List<Friend> getFriends() {
        return friends;
    }

    public void setFriends(List<Friend> friends) {
        this.friends = friends;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
