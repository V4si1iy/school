package ru.hogwarts.school.model.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class FacultyDTO {
    private Long id;
    private String color;
    private String name;
    private List<Long> studentsId;
}
