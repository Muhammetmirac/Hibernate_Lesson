package com.hb04.bi_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch04 {
    public static void main(String[] args) {

        Student04 student= new Student04();
        Diary04 diary = new Diary04();

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student04.class).addAnnotatedClass(Diary04.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // ... id li studenti getirelim
         student= session.get(Student04.class,1001);
        //diary get edelim
        diary = session.get(Diary04.class,101);
//        System.out.println(student);
//        System.out.println("--------------------------");
//        System.out.println(diary);
//        System.out.println("---------------------------");
//        System.out.println(diary.getStudent());
//        System.out.println("---------------------------");
//        System.out.println(student.getDiary());


        //iki tablonun keşim kümesini alalım(inner Join)
        String hqlQuery ="select s.name ,d.name from Student04 s inner join fetch Diary04 d on s.id=d.student";
// üsttekihql sorgunun sql cesi : select s.std_name, d.name from student04 s inner join fetch diary04 on s.id=d.std_id

       List<Object[]> resultList = session.createQuery(hqlQuery).getResultList();

        for (Object [] obje:resultList             ) {
            System.out.println(Arrays.toString(obje));
        }

//        resultList.forEach(oa->{                  ========>>>>>>>> lambda expression
//            System.out.println(Arrays.toString(oa));
//        });



        //left join*********************************
        //Kısaca bütün öğrenciler ve kitabı olan öğrencileri istiyorum

//        String hqlQuery2 =
//                "select s.name,d.name from Student04 s left join fetch Diary04 d on s.id=d.student";
//
//       List<Object[]> resultList2 = session.createQuery(hqlQuery2).getResultList();
//        for (Object[] obje: resultList2             ) {
//            System.out.println(Arrays.toString(obje));
//        }
//
//        //hql right join*************************
//        //kısaca bütün günlükler ve günlüğü olan öğrenciler
//        String hqlQuery3 =
//                "select d.name,s.name from Student04 s right join fetch Diary04 d on s.id=d.student";
//
//        List<Object[]> resultList3= session.createQuery(hqlQuery3).getResultList();
//
//        resultList3.forEach(oa->{
//            System.out.println(Arrays.toString(oa));
//        });

        //hql full join*************************** bütün student ve dairyleri getir
        String hqlQuery4 =
                "select d.name,s.name from Student04 s full join fetch Diary04 d on s.id=d.student";
        List<Object[]> resultList4= session.createQuery(hqlQuery4).getResultList();

        resultList4.forEach(oa->{
            System.out.println(Arrays.toString(oa));
        });

        tx.commit();
        sf.close();
        session.close();
    }
}