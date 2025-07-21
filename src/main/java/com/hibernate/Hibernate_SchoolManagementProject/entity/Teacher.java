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
public class Teacher {
	
	@Id  
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

    private String name;
    private String email;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Subject> subjects;

    // Optional constructor without ID and subjects
    public Teacher(String name, String email) {
        this.name = name;
        this.email = email;

}
}
