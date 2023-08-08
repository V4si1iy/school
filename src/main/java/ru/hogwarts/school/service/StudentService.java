package ru.hogwarts.school.service;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.controller.FacultyController;
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
   private static Logger logger = LoggerFactory.getLogger(StudentService.class);
    private StudentRepository studentRepository;
    FacultyService facultyService;
    FacultyRepository facultyRepository;

    public Student add(Student value) {
        logger.info("Was invoked method for add new student");
        if (value.getFaculty() != null) {
            Faculty faculty = facultyService.getById(value.getFaculty().getId());
            faculty.addStudent(value);
            facultyRepository.save(faculty);
        }
        return studentRepository.save(value);
    }

    public void remove(Long value) {
        logger.info("Was invoked method for remove student");
        Faculty faculty = facultyService.getById(value);
        faculty.removeStudent(getById(value));
        studentRepository.deleteById(value);
    }

    public void removeAll() {
        logger.info("Was invoked method for remove all students");

        studentRepository.deleteAll();
    }


    public Collection<Student> getAll() {
        logger.info("Was invoked method to get all students");
        return studentRepository.findAll();
    }

    public Student getById(Long id) {
        logger.info("Was invoked method to get student by id");
        return studentRepository.getById(id);
    }

    public List<Student> getByAge(int age) {
        logger.info("Was invoked method to get student by age");
        return studentRepository.findByAge(age);

    }

    public List<Student> findByAgeBetween(int ageMax, int ageMin) {
        logger.info("Was invoked method to find students by age between " + ageMax + " and " + ageMin);
        return studentRepository.findByAgeBetween(ageMin, ageMax);
    }

    public Faculty getFacultyByIdStudent(Long id) {
        logger.info("Was invoked method to get faculty by student id");
        Student value = getById(id);
        return value.getFaculty();
    }

    public Long getCountStudent() {
        logger.info("Was invoked method to get count of students");
        return studentRepository.getCountStudent();
    }

    public Long getAverageAge() {
        logger.info("Was invoked method to get average age of students");
        return studentRepository.getAverageAge();
    }

    public List<Student> getLastFiveStudent() {
        logger.info("Was invoked method ti get last five students");
        return studentRepository.getLastFiveStudent();
    }
}
