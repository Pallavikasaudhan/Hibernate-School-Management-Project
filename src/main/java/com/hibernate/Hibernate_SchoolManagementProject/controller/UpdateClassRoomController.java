package com.hibernate.Hibernate_SchoolManagementProject.controller;

import com.hibernate.Hibernate_SchoolManagementProject.entity.ClassRoom;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class UpdateClassRoomController {
	 public static void main(String[] args) {
	        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-jpa");
	        EntityManager em = emf.createEntityManager();
	        EntityTransaction tx = em.getTransaction();

	        try {
	            tx.begin();
	            ClassRoom classRoom = em.find(ClassRoom.class, 1);  
	            if (classRoom != null) {
	                classRoom.setName("Updated Batch");
	                classRoom.setGrade("MCA");
	                em.merge(classRoom);
	                System.out.println("ClassRoom updated.");
	            } else {
	                System.out.println("ClassRoom not found.");
	            }
	            tx.commit();
	        } catch (Exception e) {
	            tx.rollback();
	            e.printStackTrace();
	        }
	    }
}
