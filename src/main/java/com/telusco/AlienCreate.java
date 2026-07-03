package com.telusco;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class AlienCreate {
    public static void main(String[] args) {

        Laptop l1 = new Laptop();
        l1.setBrand("Asus");
        l1.setModel("Rog");
        l1.setRam(16);

        Alien al1 = new Alien();
        al1.setName("Durgesh");
        al1.setDob(LocalDate.parse("1988-04-15"));
        al1.setTech("Java");
        al1.setLaptop(l1);

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Alien.class)
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();
        Session session = sf.openSession();

        Transaction tran = session.beginTransaction();
        session.persist(l1);
        session.persist(al1);
        tran.commit();
        session.close();
        sf.close();

        System.out.println("Data inserted successfully: " + al1);
    }
}
