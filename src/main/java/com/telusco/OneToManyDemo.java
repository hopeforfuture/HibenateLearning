package com.telusco;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class OneToManyDemo {
    public static void main(String[] args) {
        Product p1 = new Product();
        Product p2 = new Product();
        Product p3 = new Product();

        p1.setName("Samsung Galaxy S7");
        p1.setDescription("A top notch smartphone from Samsung");
        p1.setPrice(12000);

        p2.setName("Redmi Note 10");
        p2.setDescription("A top notch smartphone from Redmi");
        p2.setPrice(10000);

        p3.setName("Lenevo K3 Note");
        p3.setDescription("A top notch smartphone from Lenevo");
        p3.setPrice(11000);

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Category.class)
                .addAnnotatedClass(Product.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

        Transaction tran = session.beginTransaction();
        Category c = session.find(Category.class, 2);
        c.setProducts(Arrays.asList(p1, p2, p3));
        p1.setCategory(c);
        p2.setCategory(c);
        p3.setCategory(c);
        session.persist(p1);
        session.persist(p2);
        session.persist(p3);
        session.persist(c);
        tran.commit();
        session.close();
        sf.close();

        System.out.println("Products created successfully");
    }
}
