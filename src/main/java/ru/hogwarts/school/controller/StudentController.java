package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.model.DTO.StudentDTO;
import ru.hogwarts.school.service.Mapper;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService service;
    Mapper mapper;

    public StudentController(StudentService service, Mapper mapper) {
        this.mapper = mapper;
        this.service = service;
    }

    @GetMapping("/getAll")
    public ResponseEntity<Collection<StudentDTO>> getAll() {

        return ResponseEntity.ok(service.getAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList()));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity get(@PathVariable Long id) {
        StudentDTO student = mapper.toDto(service.getById(id));
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @PostMapping()
    public ResponseEntity createStudent(@RequestBody Student student) {
        Student value = service.add(student);
        return ResponseEntity.ok(value);
    }

    @PutMapping()
    public ResponseEntity updateStudent(@RequestBody Student student) {
        Student value = service.change(student);
        return ResponseEntity.ok(value);
    }

    @DeleteMapping("{studentId}")
    public ResponseEntity deleteStudent(@PathVariable Long studentId) {
        service.remove(studentId);
        return ResponseEntity.ok("Ученик удален");
    }

    @DeleteMapping("/removeAll")
    public ResponseEntity removeAll() {
        service.removeAll();
        return ResponseEntity.ok("Ученики удалены");
    }

    @GetMapping("/sortByAge/{age}")
    public ResponseEntity getByAge(@PathVariable int age) {
        return ResponseEntity.ok(
                service.getByAge(age)
                        .stream()
                        .map(mapper::toDto)
                        .collect(Collectors.toList()));
    }

    @GetMapping("/findByAgeBetween")
    public ResponseEntity findByAgeBetween(@RequestParam int ageMin, @RequestParam int ageMax) {
        return ResponseEntity.ok(
                service.findByAgeBetween(ageMin, ageMax)
                        .stream()
                        .map(mapper::toDto)
                        .collect(Collectors.toList()));
    }

    @GetMapping("/getFacultyByIdStudent/{id}")
    public ResponseEntity getFacultyByIdStudent(@PathVariable Long id) {
        return ResponseEntity.ok(mapper.toDto(service.getFacultyByIdStudent(id)));
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getCountStudent() {
        return ResponseEntity.ok(service.getCountStudent());
    }

    @GetMapping("/AverageAge")
    public ResponseEntity<Long> getAverageAge() {
        return ResponseEntity.ok(service.getAverageAge());
    }

    @GetMapping("/getLastFiveStudent")
    public ResponseEntity<List<Student>> getLastFiveStudent() {
        return ResponseEntity.ok(service.getLastFiveStudent());
    }


}
