package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HQL_ReadData {
    public static void main(String[] args) {
        // Configuration
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student_data.class);

        // SessionFactory
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {

            // Session
            Session session = sessionFactory.openSession();

            try {
                // HQL query to find student by name
                String hql = "FROM Student_data WHERE name = :studentName";
                Query query = session.createQuery(hql);
                query.setParameter("studentName", "Adi"); // Set the name parameter

                // Execute the query and get the result
                Student_data student = (Student_data) query.uniqueResult(); // Fetch a single result

                if (student != null) {
                    // If student found, print details
                    System.out.println("Student Found: " + student.getName() + ", " + student.getCourse());
                } else {
                    // If no student found with the given name
                    System.out.println("No student found with the name: Aditya das");
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                session.close(); 
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


