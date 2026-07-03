package com.telusco;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class FetchUsersWithRoles {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration()
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Role.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

        List<User> users = session.createQuery("from User", User.class)
                .list();

        for(User u : users) {
            String name = u.getName();
            String email = u.getEmail();
            String city = u.getCity();
            StringBuilder roles = new StringBuilder();

            for(Role r : u.getRoles()) {
                roles.append(r.getName()).append(" ");
            }
            System.out.println("Name: " + name + " Email: " + email + " City: " + city + " Roles: " + roles);
        }

        session.close();
        sf.close();
    }
}
