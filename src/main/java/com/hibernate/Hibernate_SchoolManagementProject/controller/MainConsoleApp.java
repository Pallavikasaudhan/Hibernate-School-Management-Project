package com.hibernate.Hibernate_SchoolManagementProject.controller;

import java.util.Scanner;

import com.hibernate.Hibernate_SchoolManagementProject.dao.ClassRoomDao;
import com.hibernate.Hibernate_SchoolManagementProject.dao.EnrollmentDao;
import com.hibernate.Hibernate_SchoolManagementProject.dao.StudentDao;
import com.hibernate.Hibernate_SchoolManagementProject.dao.TeacherDao;
import com.hibernate.Hibernate_SchoolManagementProject.entity.ClassRoom;
import com.hibernate.Hibernate_SchoolManagementProject.entity.Student;
import com.hibernate.Hibernate_SchoolManagementProject.entity.Subject;
import com.hibernate.Hibernate_SchoolManagementProject.entity.Teacher;

public class MainConsoleApp {
	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDao studentDao = new StudentDao();
        ClassRoomDao classRoomDao = new ClassRoomDao();
        TeacherDao teacherDao = new TeacherDao();
        EnrollmentDao enrollmentDao = new EnrollmentDao();

        while (true) {
            System.out.println("\n Welcome to School Management System");
            System.out.println("1. Add New Student");
            System.out.println("2. Add New ClassRoom");
            System.out.println("3. Add New Teacher and Subjects");
            System.out.println("4. Enroll Student in Subject");
            System.out.println("5. View Subjects by Student ID");
            System.out.println("6. View Students by Subject ID");
            System.out.println("7. Exit");
            System.out.print(" Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Student Name: ");
                    String sName = sc.nextLine();
                    System.out.print("Enter Roll No: ");
                    String roll = sc.nextLine();
                    Student student = new Student(sName, roll);
                    studentDao.insertStudent(student);
                    break;

                case 2:
                    System.out.print("Enter ClassRoom Name: ");
                    String cname = sc.nextLine();
                    System.out.print("Enter Grade: ");
                    String grade = sc.nextLine();
                    ClassRoom classroom = new ClassRoom(cname, grade);
                    classRoomDao.insertClassRoom(classroom);
                    break;

                case 3:
                    System.out.print("Enter Teacher Name: ");
                    String tName = sc.nextLine();
                    System.out.print("Enter Teacher Email: ");
                    String tEmail = sc.nextLine();
                    Teacher teacher = new Teacher(tName, tEmail);

                    System.out.print("How many subjects to add? ");
                    int subCount = sc.nextInt();
                    sc.nextLine();
                    java.util.List<Subject> subjects = new java.util.ArrayList<>();

                    for (int i = 0; i < subCount; i++) {
                        System.out.print("Enter Subject Name " + (i + 1) + ": ");
                        String subName = sc.nextLine();
                        Subject subject = new Subject();
                        subject.setName(subName);
                        subject.setTeacher(teacher);
                        subjects.add(subject);
                    }

                    teacher.setSubjects(subjects);
                    teacherDao.insertTeacher(teacher);
                    break;

                case 4:
                    System.out.print("Enter Student ID: ");
                    int sid = sc.nextInt();
                    System.out.print("Enter Subject ID: ");
                    int subid = sc.nextInt();
                    System.out.print("Enter Marks: ");
                    int marks = sc.nextInt();

                    Student std = enrollmentDao.findStudentById(sid);
                    Subject sub = enrollmentDao.findSubjectById(subid);

                    if (std != null && sub != null) {
                        enrollmentDao.insertEnrollment(std, sub, marks);
                    } else {
                        System.out.println("Invalid student or subject ID.");
                    }
                    break;

                case 5:
                    System.out.print("Enter Student ID: ");
                    int sid2 = sc.nextInt();
                    enrollmentDao.getSubjectsByStudentId(sid2);
                    break;

                case 6:
                    System.out.print("Enter Subject ID: ");
                    int subid2 = sc.nextInt();
                    enrollmentDao.getStudentsBySubjectId(subid2);
                    break;

                case 7:
                    System.out.println("Exiting School Management System...");
                    studentDao.close();
                    classRoomDao.close();
                    teacherDao.close();
                    enrollmentDao.close();
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }}
}
