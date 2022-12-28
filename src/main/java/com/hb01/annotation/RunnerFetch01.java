package com.hb01.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch01 { // fetch --> çekme, anlamındadır
    public static void main(String[] args) {
        Configuration con = new Configuration().                // konfigurasyon objem hazır
                configure("hibernate.cfg.xml").
                        addAnnotatedClass(Student01.class);


        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        //DB den bir bilgi almak (fetch) için
        //      1- get() methodu ile
        //      2- SQL komutları
        //      3- HQL komutları ile ===> hibernate Query language==> ben  javaca yazarım db ye nasıl giderse gitsin yani hibernate yapsın :)))


    //1. yol get() ile *******************************************************
//        Student01 student01 = session.get(Student01.class,1001);
//        Student01 student02 = session.get(Student01.class,1002);
//        Student01 student03 = session.get(Student01.class,1003);
//        System.out.println(student01);
//        System.out.println(student02);
//        System.out.println(student03);

    //2.yol SQL ile ********************************************************************
//        String sql = "select * from t_student01";
//       List<Object[]> resultList = session.createSQLQuery(sql).getResultList();
//        for (Object[] object: resultList     ) {
//            System.out.println(Arrays.toString(object));
//        }

    //3. yol  **********************************************************************
        //Trick Bilgi : HQL yazarken tablo bilgileri yerine obje isimleri ile çalışacağız
        // HQL sorgusunda FROM da n sonra sınıf ismi kullanılır
/*       String hqlQuery = "FROM Student01";
//        List<Student01>resultList02 = session.createQuery(hqlQuery, Student01.class).getResultList();
//
//        for (Student01 student01: resultList02           ) {
//            System.out.println(student01);
        }

 */

        // Dönecek kaydın tek bir tane oldugundan emin iseniz uniqueResult() methodu kullanılabilir
    //uniqueResult() with SQL ****************************************************************

/*        String sqlQuery2 = "select * from t_student01 where student_name='Yusuf'";
//        session.createSQLQuery(sqlQuery2).uniqueResult();
//        Object [] uniqueResult1 = (Object[]) session.createSQLQuery(sqlQuery2).uniqueResult();
//        System.out.println(Arrays.toString(uniqueResult1));
//
////Yukarıda bir obje gelecek ama içinde column lar yani (datalar) oldugu için array türünde obje geldi
//        System.out.println(uniqueResult1[0]+ " : "+uniqueResult1[1]+ " : "+ uniqueResult1[2]);


 */
//uniqueResult() with HQL ****************************************************************
        String hqlQuery02 = "from Student01 where name = 'Yusuf'";
        Student01 uniqueResqult02 =  session.createQuery(hqlQuery02,Student01.class).uniqueResult();
        System.out.println(uniqueResqult02);



        tx.commit();

        session.close();
        sf.close();

    }
}
