package com.hibernate.Hibernate_SchoolManagementProject.controller;

import java.util.List;

import com.hibernate.Hibernate_SchoolManagementProject.dao.ClassRoomDao;
import com.hibernate.Hibernate_SchoolManagementProject.entity.ClassRoom;

public class ReadClassRoomController {
	 public static void main(String[] args) {
	        ClassRoomDao dao = new ClassRoomDao();

	        List<ClassRoom> classrooms = dao.getAllClassRooms();
	        System.out.println("All ClassRooms:");
	        for (ClassRoom c : classrooms) {
	            System.out.println("ID: " + c.getId() + ", Name: " + c.getName() + ", Grade: " + c.getGrade());
	        }

	    }
}
