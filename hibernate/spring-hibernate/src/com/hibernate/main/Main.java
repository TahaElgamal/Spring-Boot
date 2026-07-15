package com.hibernate.main;

import com.hibernate.model.StudentSchool;
import com.hibernate.model.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration configuration=new Configuration().addAnnotatedClass(Teacher.class).configure("hibernate.cfg.xml");
        SessionFactory sessionFactory=configuration.buildSessionFactory();
        System.out.println("sessionFactory =======> "+sessionFactory);
        Session session=sessionFactory.openSession();
        System.out.println("session =======> "+session);


    }
}