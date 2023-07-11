package ru.hogwarts.school.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@Entity

public class Avatar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String filePath;
    long fileSize;
    String mediaType;
    byte[] data;
    @OneToOne()
    Student student;
}
