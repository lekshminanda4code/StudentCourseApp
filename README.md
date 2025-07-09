# 🎓 Student Course Enrollment Console Application using Hibernate

This is a **Java console-based application** that manages student and course enrollment using **Hibernate ORM**, **MySQL**, and **Maven**.  
It features full CRUD operations and a menu-driven interface for managing student-course relationships.

---

## ✅ Features

- ➕ Add new students
- ➕ Add new courses
- 🔁 Assign courses to students
- 👀 View students with their enrolled courses
- ✏️ Update a student's name
- ❌ Delete a student (safely, removing course relationships)

---

## 🧑‍💻 Technologies Used

| Tool           | Purpose                            |
|----------------|------------------------------------|
| Java           | Core programming language          |
| Hibernate ORM  | Object Relational Mapping          |
| MySQL          | Database                           |
| Maven          | Dependency & build management      |
| Eclipse IDE    | Development environment            |

---

## 🗃️ Database Schema

- `students` table  
- `courses` table  
- `student_course` (join table for many-to-many relationship)

---

## 📁 Project Structure
StudentCourseApp/
├── src/
│ ├── main/java/com/studentcourseapp/StudentCourseApp/
│ │ ├── MainApp.java
│ │ ├── Student.java
│ │ ├── Course.java
│ │ ├── StudentDao.java
│ │ ├── CourseDao.java
│ │ └── HibernateUtil.java
│ └── resources/
│ └── hibernate.cfg.xml
├── pom.xml
└── README.md


---

## ▶️ How to Run

1. 🛠️ **Requirements**:
   - JDK 17 or later
   - Eclipse IDE
   - MySQL Server
   - Maven

2. 🧰 **Setup Steps**:
   - Clone this GitHub repo to your Eclipse workspace
   - Create a MySQL database named `studentdb`
   - Update `hibernate.cfg.xml` with your DB username/password
   - Right-click `MainApp.java` → Run As → Java Application
   - Use the menu to interact

---

## 📚 What I Learned

- Using Hibernate annotations (`@Entity`, `@ManyToMany`, etc.)
- Implementing many-to-many relationships
- Working with DAO (Data Access Object) pattern
- Building console-based CRUD apps with real database interaction
- Structuring Maven-based Java projects

---

## 📌 Future Improvements

- [ ] Add input validation (e.g., email format)
- [ ] Replace console with a GUI using JavaFX or Spring Boot + REST
- [ ] Integrate unit testing using JUnit
- [ ] Implement logging (Log4j/SLF4J) instead of `System.out.println`

---

## 👩‍💻 Author

**Nandana Lekshmi**  
🔗 GitHub: [@lekshminanda4code](https://github.com/lekshminanda4code)  
🎯 Full Stack Java Trainee at Quest Innovative Solutions

---

> 📢 *This project is a hands-on implementation developed during my Java Full Stack Developer training to master Hibernate ORM and Java–MySQL integration.*

