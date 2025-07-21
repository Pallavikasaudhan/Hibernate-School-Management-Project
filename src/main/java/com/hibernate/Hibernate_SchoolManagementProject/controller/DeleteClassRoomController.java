package com.hibernate.Hibernate_SchoolManagementProject.controller;

import com.hibernate.Hibernate_SchoolManagementProject.dao.ClassRoomDao;

public class DeleteClassRoomController {
	 public static void main(String[] args) {
	        ClassRoomDao dao = new ClassRoomDao();

	        int idToDelete = 1;  
	        dao.deleteClassRoom(idToDelete);

	    }
}
