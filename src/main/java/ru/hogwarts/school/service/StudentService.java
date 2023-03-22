package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private Map<Long, Student> storage = new HashMap<>();
    private int size;
    public Student add(Student value) {
        storage.put(value.getId(), value);
        size++;
        return value;
    }

    public Student remove(Long value) {
        size--;
        return storage.remove(value);
    }
    public Student change(Student value)
    {
        storage.replace(value.getId(), value);
        return value;
    }

    public Collection<Student> getAll() {
        return storage.values();
    }

    public Student getById(Long id)
    {
        return storage.get(id);
    }

    public Map<Long, Student> getByAge(int age)
    {
        return storage.entrySet().stream()
                .filter(e -> e.getValue().getAge()== age)
                .collect(Collectors.toMap(e->e.getKey(),e-> e.getValue()));

    }
}
