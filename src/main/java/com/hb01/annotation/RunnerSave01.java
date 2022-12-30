package com.hb01.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave01 {
    public static void main(String[] args) {


        Student01 student1 = new Student01();
        student1.setId(1001);
        student1.setName("Muhammet Mirac");
        student1.setGrade(90);

        Student01 student2 = new Student01();
        student2.setName("Yusuf");
        student2.setGrade(100);
        student2.setId(1002);

        Student01 student3 = new Student01();
        student3.setId(1003);
        student3.setGrade(95);
        student3.setName("Nazlı");

        Student01 student4 = new Student01();
        student4.setId(1004);
        student4.setGrade(90);
        student4.setName("Taha");


        Configuration con = new Configuration().
                configure("hibernate.cfg.xml"). // cofg dosyam belirtildi
                        addAnnotatedClass(Student01.class); //entity classım tanımlandı
// Hibernate configuration dosyamı ve Entity classımı bildirdim(konfigurasyon dosyamı entıty olan clasımla kullancaksın diyorum

       SessionFactory sf = con.buildSessionFactory();   // her adım bir üst adımı bir ileri taşımak için
       Session session = sf.openSession();
       Transaction tx = session.beginTransaction();  // buraya kadar transaction başlatmak için üst satırdaki kodları yazdık

        //session.save(student1);
       // session.save(student2);
        //session.save(student3);
        session.save(student4);

        tx.commit(); // database gidecek kod satırlarımız için başlatmıs olduk. yoksa db ye komutlar gitmez

        session.close();
        sf.close();



    }
}
/*
configürasyon ayarlarında "Update" ve "create" farkı
update = secili oldugu zaman tablo bir defa oluşturulur ve göderdiğimiz datalar kaydedilir. Yani persistence (kalıcı) data olur
 create = seçili oldugunda ise her seferinde tabloyu siler ve yeniden oluşturur. proje geliştirma aşamasında bu kullanılır
 */

    /*
            Default olarak configuration class'ı, main altındaki resources folder'ına gider.

            configure içerisine cfg (config) dosyamızı belirtmemiz gerekiyor

            addAnnotatedClass, Entity Class'ı belirler.

    Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);


            Session Factory Objesi oluşturduk

            Obje ile session return ettik / oluşturduk

            beginTransaction ile transaction (işlem) başlattık / transaction return ettik

    SessionFactory sf = con.buildSessionFactory();
    Session session = sf.openSession();
    Transaction tsc = session.beginTransaction();

// student1 objesini session'a kaydettik
session.save(student1);

// Transaction, Session ve SessionFactory'i kapattık
        tsc.commit();
        session.close();
        sf.close();

     */