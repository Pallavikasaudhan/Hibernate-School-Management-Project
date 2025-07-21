package com.hibernate.Hibernate_SchoolManagementProject.controller;

import com.hibernate.Hibernate_SchoolManagementProject.dao.StudentDao;

public class UpdateStudentController {
	public static void main(String[] args) {
        StudentDao dao = new StudentDao();

       
        int idToUpdate = 1;
        String newName = "Rohan Sharma";
        String newRollNo = "R999";

        dao.updateStudent(idToUpdate, newName, newRollNo);

    }
}
