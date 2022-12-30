package com.hb03.uni_onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Diary { //günlik demek
    @Id
    private int id;


    private String name;

    @OneToOne           //tek taraflı onetoone ilişki= uni_directional demektir
    @JoinColumn(name="std_id")      // name parametresini setlemezsek default değer olarak "student_id" oluşturur
    private Student03 student03;


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

    public Student03 getStudent03() {
        return student03;
    }

    public void setStudent03(Student03 student03) {
        this.student03 = student03;
    }


    @Override
    public String toString() {
        return "Diary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student03=" + student03 +
                '}';
    }
}
