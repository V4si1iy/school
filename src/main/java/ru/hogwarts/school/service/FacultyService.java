package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FacultyService {
    private Map<Long, Faculty> storage = new HashMap<>();
    private int size;

    public Faculty add(Faculty value) {
        storage.put(value.getId(), value);
        size++;
        return value;
    }

    public Faculty remove(Long value) {
        size--;
        return storage.remove(value);
    }
    public Faculty change(Faculty value)
    {
        storage.replace(value.getId(), value);
        return value;
    }

    public Collection<Faculty> getAll() {
        return storage.values();
    }

    public Faculty getById(Long id)
    {
        return storage.get(id);
    }

    public Map<Long, Faculty> getByColor(String color)
    {
        return storage.entrySet().stream()
                .filter(e -> e.getValue().getColor().equals(color))
                .collect(Collectors.toMap(e->e.getKey(),e-> e.getValue()));

    }

}
