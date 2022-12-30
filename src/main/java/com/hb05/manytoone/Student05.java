package com.hb05.manytoone;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Student05 {
@Id
private int id;
@Column(name="std_name", nullable = false)
private  String name ;

private int grade;
private LocalDateTime createOn; // oluşturulma tarihi öğrencini ünv kaydı tarihi

    @ManyToOne
    @JoinColumn(name="university_id")
    private University university;

    @PrePersist          //       Student  classından obje olusturulup bu method çağrılıp database gittiği an bu method calısır va anlık zman db ye kaydedilir
    public void prePersist(){
        createOn =LocalDateTime.now();

    }


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

    public LocalDateTime getCreateOn() {
        return createOn;
    }

//    public void setCreateOn(LocalDateTime createOn) {     // mudahale istemiyoruz. kayıt tarihi kalıcı olması lazım
//        this.createOn = createOn;
//    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return "Student05{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", createOn=" + createOn +
                ", university=" + university +
                '}';
    }
}
