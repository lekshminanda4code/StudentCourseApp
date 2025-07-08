package com.studentcourseapp.StudentCourseApp;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDao {

    // Add new student
    public void addStudent(Student student) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(student);
            tx.commit();
            System.out.println("Student added successfully.");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    // Get all students
    public List<Student> getAllStudents() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Student", Student.class).list();
        }
    }

    // Update student name
    public void updateStudentName(int id, String newName) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Student student = session.get(Student.class, id);
            if (student != null) {
                student.setName(newName);
                session.persist(student);
                tx.commit();
                System.out.println("Student name updated.");
            } else {
                System.out.println("Student not found.");
            }
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    // Delete student
    public void deleteStudent(int id) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            Student student = session.get(Student.class, id);
            if (student != null) {
                student.getCourses().clear(); // 💡 Break the many-to-many link
                session.merge(student);       // 💡 Save the update
                session.remove(student);      // ✅ Safely delete the student
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("Student not found.");
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }


    // Assign course to student
    public void assignCourseToStudent(int studentId, Course course) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Student student = session.get(Student.class, studentId);
            if (student != null && course != null) {
                student.addCourse(course); // this handles both sides
                session.merge(student);
                session.merge(course); // make sure both are updated
                tx.commit();
                System.out.println("Course assigned to student.");
            } else {
                System.out.println("Student or course not found.");
            }
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

}
