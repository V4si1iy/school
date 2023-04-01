package ru.hogwarts.school.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.FacultyRepository;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class StudentService {
    private StudentRepository studentRepository;
    FacultyService facultyService;

    public Student add(Student value) {
        return studentRepository.save(value);

    }

    public void remove(Long value) {

        studentRepository.deleteById(value);
    }

    public void removeAll() {
        studentRepository.deleteAll();
    }

    public Student change(Student value) {

        return studentRepository.save(value);
    }

    public Collection<Student> getAll() {
        return studentRepository.findAll();
    }

    public Student getById(Long id) {
        return studentRepository.findById(id).get();
    }

    public List<Student> getByAge(int age) {
        return studentRepository.findByAge(age);

    }

    public List<Student> findByAgeBetween(int ageMax, int ageMin) {
        return studentRepository.findByAgeBetween(ageMin, ageMax);
    }

    public Faculty getFacultyByIdStudent(Long id) {
        Student value = getById(id);
        Long idFaculty = value.getFaculty().getId();
        value.setFaculty(facultyService.getById(idFaculty));
        return value.getFaculty();
    }
}
