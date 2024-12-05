package org.example;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Student_data {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment ID
    private int id;
    private String name;
    private String course;

    // Default constructor
    public Student_data() {
    }

    // Parameterized constructor
    public Student_data(String name, String course) {
        this.name = name;
        this.course = course;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}


/*
package org.example;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student_data {

    @Id
    private int id;
    private String name;
    private String course;

    // Default constructor
    public Student_data() {
    }

    // Parameterized constructor (optional)
    public Student_data(int id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
*/
/*
package org.example;  // Adjust the package according to your project structure

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_data")  // The table name in the database
public class Student_data {

    @Id  // Marking this as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment for primary key
    @Column(name = "id")  // Corresponds to the 'id' column in the table
    private int id;

    @Column(name = "name")  // Corresponds to the 'name' column in the table
    private String name;

    @Column(name = "course")  // Corresponds to the 'course' column in the table
    private String course;

    // Default constructor
    public Student_data() {
    }

    // Constructor with parameters
    public Student_data(String name, String course) {
        this.name = name;
        this.course = course;
    }

    // Getter and Setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for course
    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    // Override toString method for easy display
    @Override
    public String toString() {
        return "Student_data{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
}
*/