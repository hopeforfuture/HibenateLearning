package com.telusco;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setsName("Mahesh GM");
        s1.setsAge(34);
        s1.setRollNo(104);

        SessionFactory sf = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = sf.openSession();

        Transaction tran = session.beginTransaction();
        session.persist(s1);
        tran.commit();
        session.close();
        sf.close();
        System.out.println("Data inserted successfully. Inserted object: " + s1);
    }
}