package com.studentcourseapp.StudentCourseApp;

import java.util.List;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StudentDao studentDao = new StudentDao();
        CourseDao courseDao = new CourseDao();

        while (true) {
            System.out.println("\n========= Student-Course Enrollment =========");
            System.out.println("1. Add New Student");
            System.out.println("2. Add New Course");
            System.out.println("3. Assign Course to Student");
            System.out.println("4. View All Students");
            System.out.println("5. Update Student Name");
            System.out.println("6. Delete Student");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student email: ");
                    String email = scanner.nextLine();
                    Student student = new Student(name, email);
                    studentDao.addStudent(student);
                    break;

                case 2:
                    System.out.print("Enter course title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter course duration: ");
                    String duration = scanner.nextLine();
                    Course course = new Course(title, duration);
                    courseDao.addCourse(course);
                    break;

                case 3:
                    System.out.print("Enter student ID: ");
                    int sid = scanner.nextInt();
                    System.out.print("Enter course ID: ");
                    int cid = scanner.nextInt();
                    Course selectedCourse = courseDao.getCourseById(cid);
                    if (selectedCourse != null) {
                        studentDao.assignCourseToStudent(sid, selectedCourse);
                    } else {
                        System.out.println("Course not found.");
                    }
                    break;

                case 4:
                    List<Student> students = studentDao.getAllStudents();
                    for (Student s : students) {
                        System.out.println("ID: " + s.getId() + ", Name: " + s.getName() + ", Email: " + s.getEmail());
                        System.out.println("Courses:");
                        for (Course c : s.getCourses()) {
                            System.out.println("  - " + c.getTitle() + " (" + c.getDuration() + ")");
                        }
                        System.out.println("----------------------------------");
                    }
                    break;

                case 5:
                    System.out.print("Enter student ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    studentDao.updateStudentName(updateId, newName);
                    break;

                case 6:
                    System.out.print("Enter student ID to delete: ");
                    int deleteId = scanner.nextInt();
                    studentDao.deleteStudent(deleteId);
                    break;

                case 7:
                    System.out.println("Exiting the application. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
