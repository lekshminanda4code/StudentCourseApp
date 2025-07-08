package com.studentcourseapp.StudentCourseApp;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String duration;

    @ManyToMany(mappedBy = "courses", fetch = FetchType.EAGER)
    private List<Student> students= new ArrayList<>();

    // Constructors
    public Course() {}

    public Course(String title, String duration) {
        this.title = title;
        this.duration = duration;
    }

    // Getters and setters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDuration() { return duration; }
    public List<Student> getStudents() { return students; }

    public void setTitle(String title) { this.title = title; }
    public void setDuration(String duration) { this.duration = duration; }
    public void setStudents(List<Student> students) { this.students = students; }
}

