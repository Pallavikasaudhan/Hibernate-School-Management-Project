package com.hibernate.Hibernate_SchoolManagementProject.entity;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    private String name;
	    private String rollNo;
	    public Student(String name, String rollNo) {
	        this.name = name;
	        this.rollNo = rollNo;
	    }
	    @ManyToOne
	    private ClassRoom classRoom;

	
	    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	    private List<Enrollment> enrollments;
	
	    
}
