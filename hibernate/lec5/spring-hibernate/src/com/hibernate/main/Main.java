package com.hibernate.main;

import com.hibernate.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Configuration configuration=new Configuration()
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Course.class)
                .configure("hibernate.cfg.xml");

        SessionFactory sessionFactory=configuration.buildSessionFactory();

        Session session=sessionFactory.getCurrentSession();

        Transaction transaction= session.beginTransaction();



        Course course1=new Course("java",250);
        Course course2=new Course("java2",300);
        Course course3=new Course("java3",400);
        List<Course>courses=Arrays.asList(course1,course2,course3);
        Student student1 =new Student("Taha","Cairo",courses);
        student1.setCourses(courses);

        session.persist(student1);



        transaction.commit();
        session.close();
        sessionFactory.close();





    }
}