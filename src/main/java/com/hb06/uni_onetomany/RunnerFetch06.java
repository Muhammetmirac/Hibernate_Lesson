package com.hb06.uni_onetomany;

import com.hb05.manytoone.Student05;
import com.hb05.manytoone.University;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch06 {
    public static void main(String[] args) {

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student06.class).addAnnotatedClass(Book06.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //get metodu ile
//       Student06 student = session.get(Student06.class,1001);
//        System.out.println(student);
//        System.out.println("==========================================");
//        System.out.println(student.getBookList());

        //hql sorgu ile id =101 olan kitabı getirelim
        String hqlSorgu1 = "from Book06 b where b.id=101";
        Book06 book = session.createQuery(hqlSorgu1, Book06.class).uniqueResult(); // getSingleResult() ve uniqueResult() tek data gelecekse kullanılır
        System.out.println(book);

        // bir öğrencinin kitaplarını öğrenci id ye göre getirme

        String hqlSorgu2 = "from Student06 s inner join  s.bookList b where s.id=1001";

        List<Object[]> resultList1 = session.createQuery(hqlSorgu2).getResultList();
        resultList1.forEach(oa-> System.out.println(Arrays.toString(oa)));

        //get() methodu ile
//        Student06 student = session.get(Student06.class,1001);
//        System.out.println(student.getBookList());



        tx.commit();
        sf.close();
        session.close();
    }
}
