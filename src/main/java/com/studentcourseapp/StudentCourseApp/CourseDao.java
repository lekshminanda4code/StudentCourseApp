package com.studentcourseapp.StudentCourseApp;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CourseDao {

    // Add new course
    public void addCourse(Course course) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(course);
            tx.commit();
            System.out.println("Course added successfully.");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    // Get course by ID
    public Course getCourseById(int courseId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Course.class, courseId);
        }
    }

    // Get all courses
    public List<Course> getAllCourses() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Course", Course.class).list();
        }
    }
}
