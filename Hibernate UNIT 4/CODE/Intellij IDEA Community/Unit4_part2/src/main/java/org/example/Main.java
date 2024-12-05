package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;

public class Main {
    public static void main(String[] args) {
        // Create SessionFactory and Session
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")  // Points to the Hibernate configuration file
                .addAnnotatedClass(Student.class) // Class to be mapped
                .buildSessionFactory();
             Session session = factory.openSession()) { // Use openSession() instead of getCurrentSession()

            // Create a new Student object
            Student student = new Student("Aditya", "Computer science");

            // Start transaction, save the student, and commit the transaction
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
            System.out.println("Student saved successfully!");

        } catch (HibernateException e) {
            e.printStackTrace();  // Or use a logger for better logging
        }
    }
}

/*
package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        // Create SessionFactory and Session
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")  // Points to the Hibernate configuration file
                .addAnnotatedClass(Student.class) // Class to be mapped
                .buildSessionFactory();
             Session session = factory.getCurrentSession()) {

            // Create a new Student object
            Student student = new Student("Alice", "Physics");

            // Start transaction, save the student, and commit the transaction
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();

            System.out.println("Student saved successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
*/