package com.hb05.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import java.util.List;

public class RunnerFetch05 {
    public static void main(String[] args) {

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student05.class).addAnnotatedClass(University.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //get methodu ile
      Student05 student = session.get(Student05.class,1001);
        System.out.println(student);
        System.out.println("==========================");
        System.out.println(student.getUniversity());
        System.out.println("==========================");

        //!!!--->HQL ile 1 id li unv ye giden butun ogrencileri bulalım
       String hqlSorgu = "from Student05 s where s.university.id=1";
      List<Student05> resultList = session.createQuery(hqlSorgu,Student05.class).getResultList(); // eğer sorgumuzda tek classla çalışıyorsak createQuery() içerisinde class ismi ile çağırabilirz. iki farklı classtan sorgu varsa sorgumuzu yazar bırakır Object[] ile objeye atarız
        resultList.forEach(s-> System.out.println(s));

        tx.commit();
        sf.close();
        session.close();
    }
}
