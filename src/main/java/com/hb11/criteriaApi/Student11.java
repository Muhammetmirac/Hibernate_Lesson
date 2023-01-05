package com.hb11.criteriaApi;

import javax.persistence.*;

@Entity

public class Student11 {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // idler birer birer oromatik olarak artacak
    private Long id;

    @Column(name= "student_name", nullable = false)
    private String name;

    private  int mathGrade;




    //getter setter ***************************************

    public Long getId() {
        return id;
    }

//    public void setId(Long id) {          // id otomatik generate edilecek o yüzden pasife aldık
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMathGrade() {
        return mathGrade;
    }

    public void setMathGrade(int mathGrade) {
        this.mathGrade = mathGrade;
    }
    //toString

    @Override
    public String toString() {
        return "Student11{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mathGrade=" + mathGrade +
                '}';
    }
}
