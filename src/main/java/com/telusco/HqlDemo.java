package com.telusco;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HqlDemo {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Category.class)
                .configure()
                .buildSessionFactory();
        Session session = sf.openSession();

        String search = "%Samsung%";

        Query<Product> query = session.createQuery("FROM Product " +
                "WHERE name LIKE :search", Product.class);
        query.setParameter("search", search);
        List<Product> products = query.getResultList();

        for(Product p : products) {
            System.out.println("Id: " + p.getId() + " name: " + p.getName() + " Price: " + p.getPrice());
        }

        session.close();
        sf.close();

    }
}
