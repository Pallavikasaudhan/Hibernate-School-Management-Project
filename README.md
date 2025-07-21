#  Hibernate School Management Project

This is a "Java-based School Management System" built using "Hibernate ORM" and "JPA" to manage and persist data into a "MySQL database". It demonstrates how to implement CRUD operations using Hibernate in a clean layered architecture (Entity → DAO → Controller).

---

##  Project Description

The School Management Project provides a simple simulation of how a school might store and manage information about:

- Students and their class assignments
- ClassRooms and enrolled students
- Teachers and the subjects they teach
- Subject enrollments with marks tracking

It demonstrates real-world Hibernate relationships like `@OneToMany`, `@ManyToOne`, and `@ManyToMany` using "annotations", along with "cascading", "fetching", and "entity persistence".

---

##  Features

-  Insert new Students, ClassRooms, Subjects, Teachers, and Enrollments
-  View (Read) records by ID or list all
-  Update student/classroom info
-  Delete records (with cascade handling)
-  Handles many-to-many relationships (Students <-> Subjects)
-  Uses JPA EntityManager and Transaction handling
-  Handles exceptions gracefully

---

##  Tech Stack

| Technology    | Description                     |
|---------------|---------------------------------|
| Java          | Programming language            |
| Hibernate ORM | Object-Relational Mapping (ORM) |
| JPA           | Java Persistence API            |
| MySQL         | Relational database             |
| Maven         | (Optional) Build tool           |
| Git           | Version control                 |
| IDE           | IntelliJ / Eclipse / VS Code    |

---

##  How to Run

###  Prerequisites

- Java 17+ installed
- MySQL server running
- Database: `schoolmanagement` created
- Dependencies added (Hibernate, JPA, MySQL connector)

###  Steps

1. Clone this repo:
   ```bash
   git clone https://github.com/yourusername/Hibernate-School-Management-Project.git

Developer: Pallavi Kasaudhan
