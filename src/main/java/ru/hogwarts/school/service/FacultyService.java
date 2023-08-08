package ru.hogwarts.school.service;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.FacultyRepository;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.*;

@Service
@AllArgsConstructor
public class FacultyService {
    private static Logger logger = LoggerFactory.getLogger(FacultyService.class);
    private FacultyRepository facultyRepository;
    private StudentRepository studentRepository;

    public Faculty add(Faculty value) {
        logger.info("Was invoked method for add new faculty");
        return facultyRepository.save(value);
    }

    public void remove(Long value) {
        logger.info("Was invoked method for remove faculty");
        facultyRepository.deleteById(value);
    }

    public void removeAll() {
        logger.info("Was invoked method for remove all faculties and student");
        studentRepository.deleteAll();
        facultyRepository.deleteAll();
    }


    public Collection<Faculty> getAll() {
        logger.info("Was invoked method to get all faculty");
        List<Faculty> value = facultyRepository.findAll();
        if (value.isEmpty()) {
            logger.debug("return null - list of faculties is empty");
            return null;
        } else return value;
    }

    public Faculty getById(Long id) {
        logger.info("Was invoked method to get faculty by id");
        return facultyRepository.getById(id);
    }

    public List<Faculty> getByColor(String color) {
        logger.info("Was invoked method to get faculty by color");
        List<Faculty> value = facultyRepository.getByColor(color);
        if (value.isEmpty()) {
            logger.debug("return null - list of faculties is empty");
            return null;
        } else return value;
    }

    public List<Faculty> findByNameOrColor(String name, String color) {
        logger.info("Was invoked method to find faculty by name or color");
        List<Faculty> value = facultyRepository.findByNameOrColorIgnoreCase(name, color);
        if (value.isEmpty()) {
            logger.debug("return null - list of faculties is empty");
            return null;
        }
        else return value;
    }

    public List<Student> getAllStudentsByFaculty(Long id) {
        logger.info("Was invoked method to get all students by faculty");
        return facultyRepository.getById(id).getStudents();
    }

}
