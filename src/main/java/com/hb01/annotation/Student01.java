package com.hb01.annotation;

import javax.persistence.*;


//@Entity--> Annotation ı koydugumuz sınıfı DB de bir tabloya karşılık getirir.
// Biz javaca konusuruz bunu database diline çevirmek için kullanırız
@Entity
@Table(name = "t_student01")//DB de tablo ismim "t_student01" olarak değişti
public class Student01 { //DB de "student01" isminde tablo oluşturulur (1. işlem olarak oluşturulur ancak projelerde daha uygun olan ust satırdakı@table satırı yapılır
    @Id     // primary key oluşmasını sağlıyor.
//@Column(name="std_id")// primary key seçtik ancak istediğimiz ismi bu satırla veriyoruz
    private int id;

    //Column zorunlu değil ancak customize(özelleştirme) edebilmek için gerekli
@Column(name="student_name", length =100, nullable = false,unique = false ) //nullable: false oldugunda not nulolur
    private String name;


//@Transient  // bazen bilgilerin DB ye gitmemesini istiyorsak @Transient annotationı kullanırız
    private int grade;

//@Lob // large object kısaltması Lob--> Lob ile büyük boyutlu datalar tutulabilir. şimdilik kullanmayacagımızdan yoruma alındı
//    private byte[] image;

//getter setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

//tostring
    @Override
    public String toString() {
        return "Student01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
