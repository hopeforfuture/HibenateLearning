package com.telusco;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CategoryCreate {
    public static void main(String[] args) {
        Category c = new Category();
        c.setName("Vehicles");

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Category.class)
                .addAnnotatedClass(Product.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();
        Transaction tran = session.beginTransaction();
        session.persist(c);
        tran.commit();
        session.close();
        sf.close();

        System.out.println("Category created successfully: " + c);
    }
}
