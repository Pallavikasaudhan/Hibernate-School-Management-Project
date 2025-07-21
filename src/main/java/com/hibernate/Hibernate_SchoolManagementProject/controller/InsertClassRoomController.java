package com.hibernate.Hibernate_SchoolManagementProject.controller;

import java.util.List;

import com.hibernate.Hibernate_SchoolManagementProject.dao.ClassRoomDao;
import com.hibernate.Hibernate_SchoolManagementProject.entity.ClassRoom;


public class InsertClassRoomController {
 public static void main(String[] args) {
	 ClassRoomDao dao = new ClassRoomDao();

    
     ClassRoom c1 = new ClassRoom("Advance Java", "BCA");
     dao.insertClassRoom(c1);

     
     ClassRoom fetched = dao.getClassRoomById(1);
     if (fetched != null) {
         System.out.println("Found ClassRoom: " + fetched.getName() + ", Grade: " + fetched.getGrade());
     }

    
     List<ClassRoom> list = dao.getAllClassRooms();
     System.out.println("All ClassRooms:");
     for (ClassRoom c : list) {
         System.out.println("- " + c.getName() + " (" + c.getGrade() + ")");
     }
     
 }

}
