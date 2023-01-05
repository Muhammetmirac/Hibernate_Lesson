package com.hb10.idGeneration;

import javax.persistence.*;

@Entity
public class Student10 {

    /*
   Oracle DB - PostgreSQL ---> Sequence ( kontrolü developera bırakır,
                                  Id üretilirken başlangıç değeri veya kaç tane id cachelenecek bu gibi bilgileri developer setliyebilir)
   MySQL - Microsoft SQL   ---> IDENTITY ( kontrol DB de , kendi yapısına göre ıd oluşturur, içlerindeki en basitidir)

   GenerationType.AUTO ---> Hibernate otomatik olarak stratejiyi belirler
   GenerationType.TABLE ---> En yavaşı , oyüzden çok kullanılmıyor, çünkü id
    üretmek için ekstra tablo oluşturuyor
 */
   @Id
   @GeneratedValue(generator ="sequence", strategy = GenerationType.SEQUENCE)
   @SequenceGenerator(name = "sequence", // @GeneratedValue nun generator parametresi ile aynı isme sahip olmalı
                      sequenceName = "student_seq",     //db de oluşacak sequence ismi
                      initialValue = 1000, // id başlangıç sayısı
                      allocationSize = 10  )   // cacheleme mekanizmasında 10 adet id hazır tutuyor
    private int id;

   @Column(name="student_name", nullable = false)
   private String name;









   //getter setter
    
   private int grade;

    public int getId() {
        return id;
    }

//    public void setId(int id) {               // id otomatik almasını istediğimiz için setter ihtiyacımız yok
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }


    @Override
    public String toString() {
        return "Student10{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
