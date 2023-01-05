package com.hb14.life_cycle;

import javax.persistence.*;
/*
Hinernate in Objeler ile nasıl çalıştığı ile ilgili ek bilgi :
   Entity State :
      *) Transient : Objenin newlenmiş hali, DB ile ilişkisi yok.

      *) Persisted or Managed : DB de row a karşılık geldiği durum,
                        save(),get() vs. yapıldığı zamana denk geliyor.

      *) Detached : Session kapandıktan sonra elimizdeki objenin state durumu.

      *) Removed : obje remove yapıldığı zmanki durum.
*/


@Entity
public class Student14 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name = "student_name",nullable = false)
    private String name;

    private int grade;


    //get set


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Override
    public String toString() {
        return "Student14{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
