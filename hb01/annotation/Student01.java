package com.hb01.annotation;


import javax.persistence.*;


// @Entity annotation koyduğumuz sınıfı veritabanında DB de bir tabloya karşılık getirir
// yani javaca yazımızı DB ile SQL ce iletişime geçer ve
@Entity
@Table(name ="t_student01")// DB de bu şekilde tablo ismi olarak da isimlendirebliriz "t_" standardizasyon mantığı için boyle yazmak uygun
public class Student01 {  // annotation ile DB gider ve class adında "student01" kucuk harfler Table oluşturur

    @Id// bu classda yani tabloda mutlaka 1 tane field unique olmasını(primary-key) istiyor onuda bu şekilde çözuyoruz
    //@Column(name ="std_id") // burasıda headerı isimlendirmek için kullanılır tablo isimlendirme mantığı ile aynı
    private int id; // headerler private olmalı ve bu class pojo cloass olmalıdır

    // java ile konusurken name ile yazılırı sql ile konuşurken "student_name " i kullanırız
    //column zorunlu değğil customize edebilmek için gerekli
    @Column(name ="student_name",length =100,nullable = false,unique = false )
    private  String name;

    //@Transient // DB de ki tabloda "grade" adında bir column oluşmasını engeller (githubta ki ".gitignore" gibi)
    private int grade ;

    // @Lob // Large object ile buyuk boyutlu datalar tutulabilir
    // private byte[] image;

    // getter ve setter ler oluşturuyoruz


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

    //  to string

    @Override
    public String toString() {
        return "Student01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }


}