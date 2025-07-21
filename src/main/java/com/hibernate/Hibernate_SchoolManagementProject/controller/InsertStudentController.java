package com.hibernate.Hibernate_SchoolManagementProject.controller;


import com.hibernate.Hibernate_SchoolManagementProject.dao.StudentDao;

import com.hibernate.Hibernate_SchoolManagementProject.entity.Student;



public class InsertStudentController {

	
	public static void main(String[] args) {
		 
		
        Student s1 = new Student("Pallavi", "R301");
        Student s2 = new Student("Arjun", "R302");

        
        StudentDao dao = new StudentDao();
        dao.insertStudent(s1);
        dao.insertStudent(s2);
        dao.close();

        System.out.println("Students inserted using StudentController.");
        
        
        

	}
}
