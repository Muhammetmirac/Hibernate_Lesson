package com.hb07.bi_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch07 {
    public static void main(String[] args) {

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        //get methodu ile
//        Student07 student = session.get(Student07.class,1001);
//        System.out.println(student);
//        System.out.println(student.getBookList());
//        student.getBookList().forEach(System.out::println); // lambda method reference ile
//        student.getBookList().forEach(b-> System.out.println(b));// lambda expression ile ust satır vu bu satır aynı işi yapmaktadır
//
//
//        //hql sorgu ile
//        String hqlSorgu1 = "select s.name,b.name from Book07 b inner join  Student07 s on s.id=b.student ";
//        List<Object[]> resultList = session.createQuery(hqlSorgu1).getResultList();
//
//        resultList.forEach(oa-> System.out.println(Arrays.toString(oa)));

        //sql sorgu ile öğrenci bilgilerini alalım
//        String sqlSoru="select s.student_name,b.name from book07 b inner join  student07 s on s.id=b.student_id";
//
//       List<Object[]> resultList = session.createSQLQuery(sqlSoru).getResultList();
//
//       resultList.forEach(oa-> System.out.println(Arrays.toString(oa)));


        //DELETE işlemi SQL ile
//        String sqlQuery = "delete from book07";
//       int numberOfDeleteRecord = session.createSQLQuery(sqlQuery).executeUpdate(); // executeUpdate() çalıştır guncelle sileceği içişn guncellemıs olsacak
//        System.out.println("Silinen Kayıt Sayısı : "+numberOfDeleteRecord);
//
        //hql ile delete
//        String hqlSorgu = "delete from Student07";  // sql ilq hql arasında fark sql sorgularda tablo ismi ile hql sorgularda ise class ismi ile olması
//        int silinenDataSayisi = session.createQuery(hqlSorgu).executeUpdate();

        // kitap ismine göre delete sorgusu Cin Ali kitabını sil hql ile

//        String hqlSorgu2 = "delete from Book07 b where b.name = 'Cin Ali'";
//        int silinenKitap = session.createQuery(hqlSorgu2).executeUpdate();
//        System.out.println("Silinen Data Sayisi :  "+silinenKitap );

        /*
        Kitap bilgisi olan bir öğrenciyi silmek istersek 2 yolu vardır
            1- önce book tablosundan (Child tablo) ilişkili olduğu Book lar silinir
                daha sonra istenen student objesi silinebilir
            2- Student entity classının ilgili yerine 'CASCADE/ORPHANREMOVAL' yazılarak yapılır--Student07 classında entity alanına ekleme yapıldı
         */
        /*
        orphanRemoval ile cascade arasındaki tek fark orphanremoval daha agresiftir. database de bir değer null a set edilirse
        o datayı ve ona bağlı olan bütün dataları siler. cascade ise null oldugunda hepsini silmez. her ikiside  parent child ilşkisinde parent silinince childi da siler
        kütüphane örneği kitap alan kişi silinince kitaplarda silinebilir.
        Bu yüzden her ikisini de kullanırken cok dikkat etmek gerekir

         */

        //1001 id li student objemi delete methodu ile silelim
//      Student07 student07=  session.get(Student07.class,1001);
//      session.delete(student07);

     //*** student.getBookList().set(1,null) // orphanRemoval = true oldugundan 0. indexdeki child i child tablosundan siler

      //book ismi içinde "Pele" geçen student kayıtlarını alalım (HQL ile)
        String hqlSorgu3 = "Select s from Student07 s join s.bookList b where b.name like '%Pele%'";
       List<Student07> resultList1= session.createQuery(hqlSorgu3, Student07.class).getResultList();
        for (Student07 std:resultList1          ) {
            System.out.println(std);
        }







        tx.commit();
        sf.close();
        session.close();

    }
}
