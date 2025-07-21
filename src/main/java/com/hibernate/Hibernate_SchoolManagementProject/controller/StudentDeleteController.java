package com.hibernate.Hibernate_SchoolManagementProject.controller;

import com.hibernate.Hibernate_SchoolManagementProject.dao.StudentDao;

public class StudentDeleteController {
	public static void main(String[] args) {
        StudentDao dao = new StudentDao();

       
        int idToDelete = 1; 
        dao.deleteStudent(idToDelete);

        dao.close();
    }
}
