package com.telusco;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class GetAllStudents {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = sf.openSession();

        List<Student> students = session.createQuery("from Student", Student.class)
                                        .list();

        System.out.println("List of students: ");
        for(Student s : students) {
            System.out.println("Name: " + s.getsName() + " RollNo: " + s.getRollNo() + " Age: " + s.getsAge() + " Id: " + s.getId());
        }
        session.close();
        sf.close();
    }
}
