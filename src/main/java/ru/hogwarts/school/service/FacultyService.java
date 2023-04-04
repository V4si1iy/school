package ru.hogwarts.school.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.FacultyRepository;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.*;

@Service
@AllArgsConstructor
public class FacultyService {
    private FacultyRepository facultyRepository;
    private StudentRepository studentRepository;

    public Faculty add(Faculty value) {
        return facultyRepository.save(value);
    }

    public void remove(Long value) {
        facultyRepository.deleteById(value);
    }

    public void removeAll() {
        studentRepository.deleteAll();
        facultyRepository.deleteAll();
    }

    public Faculty change(Faculty value) {
        return facultyRepository.save(value);
    }

    public Collection<Faculty> getAll() {
        return facultyRepository.findAll();
    }

    public Faculty getById(Long id) {
        return facultyRepository.findById(id).get();
    }

    public List<Faculty> getByColor(String color) {
        return facultyRepository.getByColor(color);
    }

    public List<Faculty> findByNameOrColor(String name, String color) {
        return facultyRepository.findByNameOrColorIgnoreCase(name, color);
    }

    public List<Student> getAllStudentsByFaculty(Long id) {

      return facultyRepository.getById(id).getStudents();
    }

}
