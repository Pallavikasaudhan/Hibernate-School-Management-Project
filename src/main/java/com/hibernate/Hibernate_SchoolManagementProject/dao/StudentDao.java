package com.hibernate.Hibernate_SchoolManagementProject.dao;

import java.util.List;

import com.hibernate.Hibernate_SchoolManagementProject.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class StudentDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-jpa");
    EntityManager em = emf.createEntityManager();

    public void insertStudent(Student student) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(student);
            tx.commit();
            System.out.println("Student inserted: " + student.getName());
        } catch (Exception e) {
            tx.rollback();
            System.out.println("Failed to insert student.");
            e.printStackTrace();
        }
    }
    public Student getStudentById(int id) {
        return em.find(Student.class, id);
    }

   
    public List<Student> getAllStudents() {
        return em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }
    
    public void updateStudent(int id, String newName, String newRollNo) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Student student = em.find(Student.class, id);
            if (student != null) {
                student.setName(newName);
                student.setRollNo(newRollNo);
                em.merge(student);
                System.out.println("Student updated.");
            } else {
                System.out.println("Student not found with ID: " + id);
            }
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            System.out.println("Failed to update student.");
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Student student = em.find(Student.class, id);
            if (student != null) {
                em.remove(student);
                System.out.println("Student deleted.");
            } else {
                System.out.println("Student not found with ID: " + id);
            }
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            System.out.println("Failed to delete student.");
            e.printStackTrace();
        }
    }


    public void close() {
        em.close();
        emf.close();
	   
}
}
