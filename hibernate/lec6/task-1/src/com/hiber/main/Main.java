package com.hiber.main;

import com.hiber.model.Friend;
import com.hiber.model.Post;
import com.hiber.model.User;
import com.hiber.model.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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



        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}