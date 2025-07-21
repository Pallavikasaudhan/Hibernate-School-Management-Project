package com.hibernate.Hibernate_SchoolManagementProject.dao;

import java.util.List;

import com.hibernate.Hibernate_SchoolManagementProject.entity.Teacher;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TeacherDao {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-jpa");
    private EntityManager em = emf.createEntityManager();

    public void insertTeacher(Teacher teacher) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(teacher); 
            tx.commit();
            System.out.println("Teacher inserted: " + teacher.getName());
        } catch (Exception e) {
            tx.rollback();
            System.out.println("Failed to insert teacher.");
            e.printStackTrace();
        }
    }

    public Teacher getTeacherById(int id) {
        return em.find(Teacher.class, id);
    }

    public List<Teacher> getAllTeachers() {
        return em.createQuery("SELECT t FROM Teacher t", Teacher.class).getResultList();
    }

    public void deleteTeacher(int id) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Teacher teacher = em.find(Teacher.class, id);
            if (teacher != null) {
                em.remove(teacher);
                System.out.println("Teacher deleted: " + teacher.getName());
            } else {
                System.out.println("Teacher not found with ID: " + id);
            }
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            System.out.println("Error deleting teacher.");
            e.printStackTrace();
        }
    }

    public void close() {
        em.close();
        emf.close();
    }
}
