package com.hibernate.Hibernate_SchoolManagementProject.dao;

import java.util.List;

import com.hibernate.Hibernate_SchoolManagementProject.entity.ClassRoom;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ClassRoomDao {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-jpa");
    private EntityManager em = emf.createEntityManager();
    public void insertClassRoom(ClassRoom classRoom) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(classRoom);
            tx.commit();
            System.out.println("ClassRoom inserted: " + classRoom.getName());
        } catch (Exception e) {
            tx.rollback();
            System.out.println("Failed to insert ClassRoom.");
            e.printStackTrace();
        }
    }

    public ClassRoom getClassRoomById(int id) {
        return em.find(ClassRoom.class, id);
    }

 
    public List<ClassRoom> getAllClassRooms() {
        return em.createQuery("SELECT c FROM ClassRoom c", ClassRoom.class).getResultList();
    }

   
    public void deleteClassRoom(int id) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            ClassRoom classRoom = em.find(ClassRoom.class, id);
            if (classRoom != null) {
                em.remove(classRoom);
                System.out.println("ClassRoom deleted: " + classRoom.getName());
            } else {
                System.out.println("ClassRoom not found with ID: " + id);
            }
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            System.out.println("Error deleting ClassRoom.");
            e.printStackTrace();
        }
    }
    public void close() {
        em.close();
        emf.close();

}}
