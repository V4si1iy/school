package ru.hogwarts.school.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String color;
    private String name;
    @OneToMany(mappedBy = "faculty")
    private Set<Student> students;


    public Faculty() {
    }


}
