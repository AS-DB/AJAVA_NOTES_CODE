/*
package org.example;

import org.example.Student_data;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.query.Query;

import java.util.List;

public class Read_Data {
    public static void main(String[] args) {
        // Configuration
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")  // Make sure your hibernate.cfg.xml is configured properly
                .addAnnotatedClass(Student_data.class);

        // SessionFactory
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {

            // Open a session
            Session session = sessionFactory.openSession();

            try {
                // Using Criteria API to fetch all data
                String query = "FROM Student_data";  // Using the Session’s API to fetch data

                // Retrieving list of all student data
                List<Student_data> students = session.createQuery(query).list();

                // Display all student data
                if (!students.isEmpty()) {
                    for (Student_data student : students) {
                        System.out.println("Student ID: " + student.getId() + ", Name: " + student.getName() + ", Course: " + student.getCourse());
                    }
                } else {
                    System.out.println("No students found in the database.");
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                session.close(); // Always close session after use
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
*/

package org.example;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.util.List;

public class Read_Data{
    public static void main(String[] args) {
        // Configuration
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")  
                .addAnnotatedClass(Student_data.class);

        // SessionFactory
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {

            // Open a session
            Session session = sessionFactory.openSession();

            try {
                // Create HQL query to fetch all data from Student_data table
                String hql = "FROM Student_data";  // This will fetch all records from the table
                Query query = session.createQuery(hql);

                // Execute query and retrieve all records
                List<Student_data> students = query.list();

                // Display all student data
                if (!students.isEmpty()) {
                    for (Student_data student : students) {
                        System.out.println("Student ID: " + student.getId() + ", Name: " + student.getName() + ", Course: " + student.getCourse());
                    }
                } else {
                    System.out.println("No students found in the database.");
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
