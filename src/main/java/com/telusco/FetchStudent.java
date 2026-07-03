package com.telusco;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchStudent {
    public static void main(String[] args) {
        Student s2 = null;

        SessionFactory sf = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = sf.openSession();

        s2 = session.find(Student.class, 2);
        session.close();
        sf.close();

        if(s2 == null) {
            System.out.println("No data found");
        } else {
            System.out.println("Name: " + s2.getsName() + " Age: " + s2.getsAge() + " Rollno: " + s2.getRollNo());
        }
    }
}
