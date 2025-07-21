package com.hibernate.Hibernate_SchoolManagementProject.controller;

import com.hibernate.Hibernate_SchoolManagementProject.dao.EnrollmentDao;
import com.hibernate.Hibernate_SchoolManagementProject.entity.Student;
import com.hibernate.Hibernate_SchoolManagementProject.entity.Subject;


public class InsertEnrollmentController {
	
		 public static void main(String[] args) {
		        EnrollmentDao dao = new EnrollmentDao();

		        Student student = dao.findStudentById(1);  
		        Subject subject = dao.findSubjectById(1); 

		        if (student != null && subject != null) {
		            dao.insertEnrollment(student, subject, 88); 
		        } else {
		            System.out.println("Invalid student or subject ID.");
		        }

		        dao.close();
    }
}
