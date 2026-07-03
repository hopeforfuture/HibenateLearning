package com.telusco;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class ManyToManyDemo {
    public static void main(String[] args) {
        User u1 = new User();
        User u2 = new User();
        User u3 = new User();

        Role r1 = new Role();
        Role r2 = new Role();
        Role r3 = new Role();
        Role r4 = new Role();

        r1.setName("Admin");
        r2.setName("Sub Admin");
        r3.setName("User");
        r4.setName("Publisher");

        u1.setName("User A");
        u1.setEmail("test1@gmail.com");
        u1.setCity("Bengaluru");

        u2.setName("User B");
        u2.setEmail("test2@gmail.com");
        u2.setCity("Hyderabad");

        u3.setName("User C");
        u3.setEmail("test3@gmail.com");
        u3.setCity("Chennai");

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Role.class)
                .addAnnotatedClass(User.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();
        Transaction tran = session.beginTransaction();
        u1.setRoles(Arrays.asList(r1));
        u2.setRoles(Arrays.asList(r2, r4));
        u3.setRoles(Arrays.asList(r3));

        session.persist(r1);
        session.persist(r2);
        session.persist(r3);
        session.persist(r4);

        session.persist(u1);
        session.persist(u2);
        session.persist(u3);

        tran.commit();
        session.close();
        sf.close();
    }
}
