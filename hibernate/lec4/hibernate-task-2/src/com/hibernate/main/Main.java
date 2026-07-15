package com.hibernate.main;

import com.hibernate.model.Doctor;
import com.hibernate.model.DoctorDetails;
import com.hibernate.model.Hospital;
import com.hibernate.model.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration configuration=new Configuration()
                .addAnnotatedClass(Hospital.class)
                .addAnnotatedClass(Doctor.class)
                .addAnnotatedClass(DoctorDetails.class)
                .addAnnotatedClass(Patient.class)
                .configure("hibernate.cfg.xml");

        SessionFactory sessionFactory =configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();


        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}