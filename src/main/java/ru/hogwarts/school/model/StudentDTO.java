package ru.hogwarts.school.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentDTO {
    private Long Id;
    private String name;
    private int age;
    private Long facultyId;
    private Long avatarId;
}
