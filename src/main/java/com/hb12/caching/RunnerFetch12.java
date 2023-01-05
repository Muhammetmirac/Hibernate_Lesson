package com.hb12.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch12 {
    public static void main(String[] args) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student12.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // 1- get ile öğrenci çekelim

        System.out.println("İlk get İşlemi 1 id li öğrenci için ");
        Student12 student1 =  session.get(Student12.class,1L);


       // session.clear();  cache için sıfırlamak için kullandık

        System.out.println("ikinci get işlemi 1 id li öğrenci için");
        Student12 student2 =  session.get(Student12.class,1L);


        tx.commit();
        session.close();

        /*
        first level cache mekanizmasında alt satırdaki kodlar için yeni bir query oluşturulur
         */


        Session session1 = sf.openSession();
        Transaction tx2 = session1.beginTransaction();
        System.out.println("Session close sonras 1 id li öğrenci için ");
        Student12 student3 =  session1.get(Student12.class,1L);

        tx2.commit();

        session1.close();
        sf.close();
    }
}
