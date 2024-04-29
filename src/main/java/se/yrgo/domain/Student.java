package se.yrgo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String enrollmentID;
    private String name;

    @Column(name = "NUM_COURSES")
    private Integer numberOfCourses;

    public Student(String name) {
        this.name = name;
    }

    public Student() {
    }

    public String toString() {
        return "name:" + name;
    }

    public int getId() {
        return id;
    }

    public String getEnrollmentID() {
        return enrollmentID;
    }

}
