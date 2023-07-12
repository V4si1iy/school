package ru.hogwarts.school.service;

import org.springframework.stereotype.Component;
import ru.hogwarts.school.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Mapper {
    public AvatarDTO toDto(Avatar avatar) {
        Long id = avatar.getId();
        String filePath = avatar.getFilePath();
        long fileSize = avatar.getFileSize();
        String mediaType = avatar.getMediaType();
        Long studentId;
        if (avatar.getStudent() == null) {
            studentId = null;
        } else studentId = avatar.getStudent().getId();
        return new AvatarDTO(id, filePath, fileSize, mediaType, studentId);
    }

    public StudentDTO toDto(Student student) {
        Long id = student.getId();
        String name = student.getName();
        int age = student.getAge();
        Long facultyId;
        Long avatarId;
        if (student.getFaculty() != null) {
            facultyId = student.getFaculty().getId();
        } else facultyId = null;
        if (student.getAvatar() != null) {
            avatarId = student.getAvatar().getId();
        } else avatarId = null;

        return new StudentDTO(id, name, age, facultyId, avatarId);
    }

    public FacultyDTO toDto(Faculty faculty) {
        Long id = faculty.getId();
        String name = faculty.getName();
        String color = faculty.getColor();
        List<Long> studentsId;
        if (faculty.getStudents().isEmpty()) {
            studentsId = new ArrayList<>();
        } else {
            studentsId = faculty.getStudents()
                    .stream()
                    .map(e -> e.getId())
                    .collect(Collectors.toList());
        }
        return new FacultyDTO(id, color, name, studentsId);
    }

}
