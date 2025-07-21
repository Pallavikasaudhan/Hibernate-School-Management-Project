package com.hibernate.Hibernate_SchoolManagementProject.controller;

import java.util.Arrays;

import com.hibernate.Hibernate_SchoolManagementProject.dao.TeacherDao;
import com.hibernate.Hibernate_SchoolManagementProject.entity.Subject;
import com.hibernate.Hibernate_SchoolManagementProject.entity.Teacher;

public class InsertTeacherController {
	public static void main(String[] args) {
       
        Teacher teacher = new Teacher("Dr. Mehta", "mehta@school.edu");

        Subject subject1 = new Subject();
        subject1.setName("Computer Science");
        subject1.setTeacher(teacher);

        Subject subject2 = new Subject();
        subject2.setName("Data Structures");
        subject2.setTeacher(teacher);

        teacher.setSubjects(Arrays.asList(subject1, subject2));

        TeacherDao dao = new TeacherDao();
        dao.insertTeacher(teacher);
        dao.close();

        System.out.println("Teacher and Subjects inserted via DAO.");
    }
}
