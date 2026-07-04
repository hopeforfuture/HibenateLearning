package com.telusco;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.util.List;

public class ProductSummaryDisplay {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Category.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

        Query<ProductSummary> query = session.createQuery("SELECT new com.telusco.ProductSummary("
        + "p.name, p.price, c.name)"
        + " from Product p JOIN p.category c", ProductSummary.class);

        List<ProductSummary> list = query.getResultList();

        for(ProductSummary p : list) {
            System.out.println("Name: " + p.getProductName() + " Category: " + p.getCategoryName() +
                    " Price: " + p.getPrice());
        }

        session.close();
        sf.close();
    }
}
