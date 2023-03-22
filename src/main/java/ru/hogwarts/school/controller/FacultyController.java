package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;

import ru.hogwarts.school.service.FacultyService;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    private final FacultyService service;

    public FacultyController(FacultyService service) {
        this.service = service;
    }

    @GetMapping("/getAll")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity get(@PathVariable Long id) {
        Faculty faculty = service.getById(id);
        if (faculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }

    @PostMapping()
    public ResponseEntity createFaculty(@RequestBody Faculty faculty) {
        Faculty value = service.add(faculty);
        return ResponseEntity.ok(value);
    }

    @PutMapping()
    public ResponseEntity updateFaculty(@RequestBody Faculty faculty) {
        Faculty value = service.change(faculty);
        return ResponseEntity.ok(value);
    }
    @DeleteMapping("/{facultyId}")
    public ResponseEntity deleteFaculty( @PathVariable Long facultyId)
    {
        return ResponseEntity.ok(service.remove(facultyId));
    }

    @GetMapping("/sortByColor/{color}")
    public ResponseEntity getByColor(@PathVariable String color)
    {
        return ResponseEntity.ok(service.getByColor(color));
    }
}
