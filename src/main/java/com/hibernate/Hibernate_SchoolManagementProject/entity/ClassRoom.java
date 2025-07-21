package com.hibernate.Hibernate_SchoolManagementProject.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ClassRoom {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

    private String name;
    private String grade;

    @OneToMany(mappedBy = "classRoom", cascade = CascadeType.ALL)
    private List<Student> students;

    
    public ClassRoom(String name, String grade) {
        this.name = name;
        this.grade = grade;
}
}
