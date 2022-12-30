package com.hb04.bi_onetoone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Student04 {
    @Id
    private int id;     // projelerde Long id; olarak belirtilir
    @Column(name="std_name",length = 100)
    private String name;

    private int grade;

    @OneToOne(mappedBy = "student") // diary classında oluşturmus oldugumuz Student04 student variable ismi student oldugu için burayada student yazdık
                                    // sadece Diary tablosunda ilişki için yeni bir kolon oluşmasını sağlıyor. Student04 de bosyere olusturma diyoe
    private Diary04 diary;

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

    public Diary04 getDiary() {
        return diary;
    }

    public void setDiary(Diary04 diary) {
        this.diary = diary;
    }


    @Override
    public String toString() {
        return "Student04{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                //", diary=" + diary +   Eğer burada aktif olursa  method çıktısında sonsuz döngüye sebep olur
                '}';
    }
}
