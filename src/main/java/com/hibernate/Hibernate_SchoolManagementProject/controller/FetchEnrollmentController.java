package com.hibernate.Hibernate_SchoolManagementProject.controller;

import java.util.Scanner;

import com.hibernate.Hibernate_SchoolManagementProject.dao.EnrollmentDao;

public class FetchEnrollmentController {
	 public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);
	        EnrollmentDao dao = new EnrollmentDao();

	        System.out.println(" Fetch Enrollment Data");
	        System.out.println("1. View Subjects by Student ID");
	        System.out.println("2. View Students by Subject ID");
	        System.out.print("Enter your choice: ");
	        int choice = sc.nextInt();

	        switch (choice) {
	            case 1:
	                System.out.print(" Enter Student ID: ");
	                int sid = sc.nextInt();
	                dao.getSubjectsByStudentId(sid);
	                break;

	            case 2:
	                System.out.print(" Enter Subject ID: ");
	                int subid = sc.nextInt();
	                dao.getStudentsBySubjectId(subid);
	                break;

	            default:
	                System.out.println("Invalid choice.");
	        }

	        dao.close();
	        sc.close();
	    }
}
