package com.hb06.uni_onetomany;

import com.hb05.manytoone.Student05;
import com.hb05.manytoone.University;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave06 {
    public static void main(String[] args) {

       Student06 student1= new Student06();
       student1.setId(1001);
       student1.setName("Betul Şener");
       student1.setGrade(75);

       Student06 student2= new Student06();
       student2.setId(1002);
       student2.setName("Tarık Bey");
       student2.setGrade(75);

       Student06 student3= new Student06();
       student3.setId(1003);
       student3.setName("Ömer Bey");
       student3.setGrade(75);

       Book06 book01 = new Book06();
       book01.setId(101);
       book01.setName("Art Book");

       Book06 book02 = new Book06();
       book02.setId(102);
       book02.setName("Math Book");

       Book06 book03 = new Book06();
       book03.setId(103);
       book03.setName(" Java Book");

       student1.getBookList().add(book01);
       student1.getBookList().add(book02);
       student2.getBookList().add(book03);



        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student06.class).addAnnotatedClass(Book06.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(book01);
        session.save(book02);
        session.save(book03);

        session.save(student1);
        session.save(student2);
        session.save(student3);

        tx.commit();
        sf.close();
        session.close();
    }
}
