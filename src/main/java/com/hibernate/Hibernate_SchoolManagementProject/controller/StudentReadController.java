package com.hibernate.Hibernate_SchoolManagementProject.controller;

import java.util.List;

import com.hibernate.Hibernate_SchoolManagementProject.dao.StudentDao;
import com.hibernate.Hibernate_SchoolManagementProject.entity.Student;

public class StudentReadController {
	 public static void main(String[] args) {
	        StudentDao dao = new StudentDao();

	       
	        int id = 1;  
	        Student s = dao.getStudentById(id);
	        if (s != null) {
	            System.out.println("Student Found:");
	            System.out.println("ID: " + s.getId());
	            System.out.println("Name: " + s.getName());
	            System.out.println("Roll No: " + s.getRollNo());
	        } else {
	            System.out.println("Student not found with ID: " + id);
	        }

	       
	        System.out.println("\nAll Students:");
	        List<Student> allStudents = dao.getAllStudents();
	        for (Student stu : allStudents) {
	            System.out.println("ID: " + stu.getId() + ", Name: " + stu.getName() + ", Roll No: " + stu.getRollNo());
	        }
	 }
}
