package com.hibernate.Hibernate_SchoolManagementProject.entity;

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
public class Subject {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    private Teacher teacher;
    
    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    private java.util.List<Enrollment> enrollments;


    // Optional constructor
    public Subject(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
    }

}
