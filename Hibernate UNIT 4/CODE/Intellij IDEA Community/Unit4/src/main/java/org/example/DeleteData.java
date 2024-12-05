package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;

public class DeleteData {
    public static void main(String[] args) {
        // Configuration
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student_data.class);

        // SessionFactory
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {

            // Session
            Session session = sessionFactory.openSession();

            // Begin Transaction
            Transaction transaction = session.beginTransaction();

            try {
                // Get the student object to delete (e.g., by ID)
                int studentId = 1; // Assume you want to delete the student with ID 1
                Student_data student = session.get(Student_data.class, studentId);

                if (student != null) {
                    session.delete(student); // Delete the student from the database
                    System.out.println("Student deleted successfully!");
                } else {
                    System.out.println("Student not found with ID: " + studentId);
                }

                // Commit the transaction
                transaction.commit();

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
