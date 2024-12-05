package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;

public class Insertdata {
    public static void main(String[] args) {
        //Configuration
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student_data.class);

        //SessionFactory
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {

            //Session
            Session session = sessionFactory.openSession();

            //Begin Transaction
            Transaction transaction = session.beginTransaction();

            // Persistent Entity
            try {
                Student_data student = new Student_data(); // Transient state
                student.setName("Aditya das");
                student.setCourse("Computer Science");

                session.save(student); // Persistent state

                //Transaction
                transaction.commit();
                System.out.println("Student saved successfully!");

            } catch (HibernateException e) {
                // Rollback transaction if any issue occurs
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();

            } finally {
                session.close();
            }

        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
