package com.telusco;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteStudent {
    public static void main(String[] args) {
        Student s2 = null;

        SessionFactory sf = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = sf.openSession();
        s2 = session.find(Student.class, 3);
        Transaction tran = session.beginTransaction();
        session.remove(s2);
        tran.commit();

        System.out.println("Student deleted.");
    }
}
