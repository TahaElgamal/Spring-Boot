package com.hibernate.main;

import com.hibernate.model.Player;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration configuration=new Configuration()
                .addAnnotatedClass(Player.class)
                .configure("hibernate.cfg.xml");

        SessionFactory sessionFactory =configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

        /*Player player=new Player("taha",24,true);
        session.save(player);*/

        /*Player player=session.get(Player.class,1L);
        session.detach(player);
        player.setName("mohamed");
        session.update(player);*/

        /*Player player=session.get(Player.class,1L);
        System.out.println(player.getName());
        System.out.println(player.getAge());
        System.out.println(player.isStatus());*/


//        session.delete(session.get(Player.class,1L));

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}