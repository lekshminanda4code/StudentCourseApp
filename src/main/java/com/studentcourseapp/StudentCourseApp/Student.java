package com.studentcourseapp.StudentCourseApp;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


 @Entity
 @Table(name = "students")

public class Student {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    private String name;
	    private String email;

	    @ManyToMany(fetch = FetchType.EAGER)
	    @JoinTable(
	        name = "student_course",
	        joinColumns = @JoinColumn(name = "student_id"),
	        inverseJoinColumns = @JoinColumn(name = "course_id")
	    )
	    private List<Course> courses = new ArrayList<>();

	    // Constructors
	    public Student() {}

	    public Student(String name, String email) {
	        this.name = name;
	        this.email = email;
	    }

	    // Getters and setters
	    public int getId() { return id; }
	    public String getName() { return name; }
	    public String getEmail() { return email; }
	    public List<Course> getCourses() { return courses; }

	    public void setName(String name) { this.name = name; }
	    public void setEmail(String email) { this.email = email; }
	    public void setCourses(List<Course> courses) { this.courses = courses; }

	    public void addCourse(Course course) {
	    	this.courses.add(course);
	        // Maintain bidirectional relationship
	        if (!course.getStudents().contains(this)) {
	            course.getStudents().add(this);
	        }
	    }

}
