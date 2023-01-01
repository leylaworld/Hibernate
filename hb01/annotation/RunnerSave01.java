package com.hb01.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class RunnerSave01 {
    public static void main(String[] args) {

        Student01 student1 =new Student01();
        student1.setId(1001);
        student1.setName("Yigit er");
        student1.setGrade(95);

        Student01 student2 =new Student01();
        student2.setId(1002);
        student2.setName("Ali can");
        student2.setGrade(89);

        Student01 student3 =new Student01();
        student3.setId(1003);
        student3.setName("Veli cem");
        student3.setGrade(45);

        // hibernate e configurasyon dosyamı ve entity clasımı bildirdim
        Configuration con =new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);


        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        //session.save(student1);// bu .save ile db ye gönderirirz
        session.save(student2); //update de iken 1 kısım pasıf olmalı yoksa hata verir
        //session.save(student3);
        //  cfg.xml update olarak ayarlandığı için pasif olaraj ayarladık hata vermemesi için


        tx.commit(); // commit yapoılmaz sa DB ye bilgiler gitmez

        session.close();// ram de çalışmaması için close ları yaparız
        sf.close();
        // evet bu code her zaman run  ettiğimizde yeniden oluştururz bu ayarlama yeri
        // hibernate.cfg.xml resources kısmından yapılıyor (create, update ,delete ) gibi ayarlamalar yapılır
    }
}