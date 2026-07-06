package com.telusco;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class AlienFetch {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Alien.class)
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();
        Session session = sf.openSession();

        List<Alien> aliens = session.createQuery("from Alien", Alien.class)
                .list();
        System.out.println("-----List of Aliens-----");
        for(Alien a : aliens) {
            int age = Period.between(a.getDob(), LocalDate.now()).getYears();

            System.out.println("Id: " + a.getId() + " Name: " + a.getName() + " Age: " + age + " Tech stack: " + a.getTech()
            + " Laptop: " + a.getLaptop());
        }
    }
}
