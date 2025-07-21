package com.hibernate.Hibernate_SchoolManagementProject.dao;

import java.util.List;

import com.hibernate.Hibernate_SchoolManagementProject.entity.Enrollment;
import com.hibernate.Hibernate_SchoolManagementProject.entity.Student;
import com.hibernate.Hibernate_SchoolManagementProject.entity.Subject;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class EnrollmentDao {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-jpa");
    private EntityManager em = emf.createEntityManager();

   
    public void insertEnrollment(Student student, Subject subject, int marks) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Enrollment enrollment = new Enrollment(student, subject, java.time.LocalDate.now(), marks);
            em.persist(enrollment);
            tx.commit();
            System.out.println("Enrollment inserted.");
        } catch (Exception e) {
            tx.rollback();
            System.out.println("Failed to insert enrollment.");
            e.printStackTrace();
        }
    }
 
    public List<Enrollment> getEnrollmentsByStudentId(int studentId) {
        return em.createQuery("SELECT e FROM Enrollment e WHERE e.student.id = :id", Enrollment.class)
                 .setParameter("id", studentId)
                 .getResultList();
    }

    public List<Enrollment> getEnrollmentsBySubjectId(int subjectId) {
        return em.createQuery("SELECT e FROM Enrollment e WHERE e.subject.id = :id", Enrollment.class)
                 .setParameter("id", subjectId)
                 .getResultList();
    }

    public void getSubjectsByStudentId(int studentId) {
        List<Enrollment> list = getEnrollmentsByStudentId(studentId);
        if (list.isEmpty()) {
            System.out.println("No subjects found for Student ID: " + studentId);
            return;
        }

        System.out.println("Subjects enrolled by Student ID " + studentId + ":");
        for (Enrollment e : list) {
            System.out.println("- " + e.getSubject().getName() + " | Marks: " + e.getMarks());
        }
    }

    public void getStudentsBySubjectId(int subjectId) {
        List<Enrollment> list = getEnrollmentsBySubjectId(subjectId);
        if (list.isEmpty()) {
            System.out.println("No students found for Subject ID: " + subjectId);
            return;
        }

        System.out.println("Students enrolled in Subject ID " + subjectId + ":");
        for (Enrollment e : list) {
            System.out.println("- " + e.getStudent().getName() + " | Roll No: " + e.getStudent().getRollNo());
        }
    }


    public Student findStudentById(int id) {
        return em.find(Student.class, id);
    }

    public Subject findSubjectById(int id) {
        return em.find(Subject.class, id);
    }

    public void close() {
        em.close();
        emf.close();
	    }
}
