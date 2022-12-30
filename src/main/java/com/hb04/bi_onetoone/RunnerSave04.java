package com.hb04.bi_onetoone;

import com.hb03.uni_onetoone.Diary;
import com.hb03.uni_onetoone.Student03;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave04 {

    public static void main(String[] args) {

        Student04 student1 = new Student04();
        student1.setId(1001);
        student1.setName("Emir");
        student1.setGrade(85);

        Student04 student2 = new Student04();
        student2.setId(1002);
        student2.setName("Fatih arzu");
        student2.setGrade(85);
        Student04 student3 = new Student04();
        student3.setId(1003);
        student3.setName("Rıdvan");
        student3.setGrade(85);

        Diary04 diary1 = new Diary04();
        diary1.setId(101);
        diary1.setName("Emirin Diary");
        diary1.setStudent(student1);

        //student1.setDiary(diary1)--> ilişki sahibi olmayan Student clasından Diaryi setlemek istersek Null donuc alırız

        Diary04 diary2 = new Diary04();
        diary2.setId(102);
        diary2.setName("Fatihin Diary");
        diary2.setStudent(student2);

        Diary04 diary3 = new Diary04();
        diary3.setId(103);
        diary3.setName("mirac Diary");


        /*
        İlişki sahibi kim ise mapleme onun üzerinden yapılır.
        yukarıda ilişki sahibi Diary oldugu için setStudent methodunu kullanıyoruz
         */

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student04.class).addAnnotatedClass(Diary04.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);

        session.save(diary1);
        session.save(diary2);
        session.save(diary3);

        tx.commit();
        sf.close();
        session.close();


    }
}
