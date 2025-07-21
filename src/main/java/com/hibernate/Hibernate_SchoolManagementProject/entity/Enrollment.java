package com.hibernate.Hibernate_SchoolManagementProject.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Enrollment {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    private LocalDate enrollmentDate;
	    private int marks;

	    @ManyToOne
	    private Student student;

	    @ManyToOne
	    private Subject subject;

	    public Enrollment(Student student, Subject subject, LocalDate enrollmentDate, int marks) {
	        this.student = student;
	        this.subject = subject;
	        this.enrollmentDate = enrollmentDate;
	        this.marks = marks;
	    }

}
