package com.hb13.get_load;

import com.hb12.caching.Student12;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/*
   get() ---> gerçek nesneyi döndürür ,
               nesne yoksa null döner
               nesnenin olduğundan emin değilseniz get() kullanın
               dönen nesneye hemen kullanacaksam get() kullanılmalı
   load() --> proxy nesne döndürür, gerçek nesnenin gölgesi ,
               nesne yoksa exception fırlatır
               dönen nesne üzerinde delete yapılacaksa kullanılabilir
 */


public class RunnerFetch13 {
    public static void main(String[] args) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student13.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        System.out.println("get methodunun başlangıç yeri ..");
        Student13 student1 = session.get(Student13.class, 1L);
        System.out.println("Get methodunun bittiği satır");
        System.out.println("Student ID : " + student1.getId());
        System.out.println("Student get Name : " + student1.getName());

        System.out.println("*********************************");
        // yukardaki senaryonun aynısını load() methodu ile yapalım
        System.out.println("Load methodunun başlangıç yeri : ");
        Student13 student2 = session.load(Student13.class, 2L);
        System.out.println("getName cagrıldı");
        System.out.println("Student2 nin ismi :" + student2.getName());
        System.out.println("getNamre bitti");
        System.out.println("Load methodunun bittiği satır");


/*
Load methodu cagrıldıgında butun dataları cagırır
Örnekte name istedik run da hibernate in yazmıs oldugu sorguda hepsini istediğini görürüz
get methodu ise istenilen data ne ise onu getirir
 */


        //DB de olmayan datayı(ID) mesela istersek ne olacağını görelim
        System.out.println("get() metodu calısmaya basladı");
        Student13 student3 = session.get(Student13.class, 5L); // null oldugunu bildiğimiz id istedik
        System.out.println("get methodu bitti");

        //System.out.println("Student ID : "+student3.getId()); // nullpointerException attı çünkü  get methodu null dondurdu
        //null olan objeden data istesekde bos oldugu için exception attı
        if (student3 != null) {

            System.out.println("Student getName : " + student3.getName()); // burada ise if e girmediği için exception atmaz
        }

        System.out.println("*********************************************");
        System.out.println("Loada methodu yukarıdakı gıbı calsısmaya basladı");

        Student13 student4 = session.load(Student13.class, 10L);
        /*
        load methodu proxy data getirir. yani objeyi getirmiş gibi yapar. ama tamamen sanal bir durumdur ancak
        objyı kullanmak istersek exception atar

         */

        if(student4!=null){                 // burada obje varmıs gibi davrandıgı için if e girdi ama içeride hata verdi
            System.out.println(student4.getId());
            System.out.println(student4.getName());
        }


        System.out.println("load methodu bitti");

         // peki load() merhodu nerelerde kullanılır
        /*
        load methodu ile objenin referansı alınır ve sonra delete cagrılır
        get methodu cagrılmayarak DB ye hit engellenmiş olur. (hit : db ye gidip sorgu göndermek anlamında)
         */


//        Student13 student5 = session.get(Student13.class,1L);  // get ile
//        session.delete(student5);
        Student13 student6 = session.load(Student13.class,1L);  // load ile
        session.delete(student6);












        tx.commit();  // yazmazsak DB ye bilgilerimiz gitmez....
        session.close();  // kapat
        sf.close();  // kapat
    }
}
   /*   get () ve load() Metot Farkları
        Hibernate Session , veritabanından veri almak için farklı yöntemler sağlar. Bunlardan ikisi - get() ve load()'dur . Ayrıca bunlar için farklı durumlarda kullanabileceğimiz çok fazla overload yöntem var. İlk bakışta her ikisi de get() benzer load() görünüyor gibi görünse de (çünkü her ikisi de veri tabanından veri getiriyor) ancak aralarında bazı farklar vardır.
        get() metodu kullanarak bir id ile sorgu yapıldığında eğer kayıt bulunumaz ise null döndürür.
        get() metodu kullanarak bir id ile sorgu yapıldığında dönen nesne üzerinde bir özellik çağrımı yapıldığında ObjectNotFoundException throw edilecektir.
        get () metodu verileri çağrıldığı anda yüklerken load() bir proxy nesnesi döndürür.
        get () metodu getirmek için kullanılırken load() metodu delete isteği için kullanılabilir.

    */