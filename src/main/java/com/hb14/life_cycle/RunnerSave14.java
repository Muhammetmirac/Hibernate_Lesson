package com.hb14.life_cycle;

import com.hb13.get_load.Student13;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave14 {
    public static void main(String[] args) {

        Student14 student1 = new Student14(); // Transiet durumunda--> Su anda olustu ancak db ile iletişim kurmadı
        student1.setName("Recep Bey");
        student1.setGrade(99);

        Student14 student2 = new Student14();
        student2.setName("Emir Bey");
        student2.setGrade(99);

        Student14 student3 = new Student14();
        student3.setName("Tarık Bey");
        student3.setGrade(99);

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student13.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student1); // persisted state --> hibernate radarına girdi
        student1.setName("Güncellenmiş Recep Bey");

        session.evict(student1);// detached state --> evict methodu ile takibi bırak dedik
                                // bundan sonra  takibi bıraktığı için hiç bir işlem yapmaz kayıt olusmaz
        session.update(student1); //detached olmus student1 objesini persisted State e alır
        session.merge(student1); //detached olmus student1 objesini persisted State e alır


        tx.commit();  // yazmazsak DB ye bilgilerimiz gitmez....
        session.close();  // kapat
        sf.close();  // kapat
    }
}