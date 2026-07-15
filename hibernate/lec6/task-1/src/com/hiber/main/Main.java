package com.hiber.main;

import com.hiber.model.Friend;
import com.hiber.model.Post;
import com.hiber.model.User;
import com.hiber.model.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Configuration configuration=new Configuration()
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(UserDetails.class)
                .addAnnotatedClass(Friend.class)
                .addAnnotatedClass(Post.class)
                .configure("hibernate.cfg.xml");

        SessionFactory sessionFactory =configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

        /*User user = new User();
        user.setName("Taha");
        user.setAge(24);

        UserDetails details = new UserDetails();
        details.setAddress("Cairo");
        details.setPhone("01012345678");


        user.setUserDetails(details);
        details.setUser(user);


        session.save(user);
        session.save(details);*/


        /*User user = new User();
        user.setName("Taha");
        user.setAge(24);

        UserDetails details = new UserDetails();
        details.setAddress("Cairo");
        details.setPhone("01012345678");

        user.setUserDetails(details);
        details.setUser(user);

        session.persist(user);

        Friend friend1 = new Friend();
        friend1.setName("Ali");

        Friend friend2 = new Friend();
        friend2.setName("Omar");

        user.setFriends(Arrays.asList(friend1, friend2));
        session.persist(user);

        Post post1 = new Post();
        post1.setHeader("Java");
        post1.setContent("Hibernate");
        post1.setUser(user);

        Post post2 = new Post();
        post2.setHeader("Spring");
        post2.setContent("Spring Boot");
        post2.setUser(user);

        user.setPosts(Arrays.asList(post1, post2));

        session.persist(user);*/




        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}