package ru.hogwarts.school.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.HashMap;
import java.util.Map;

@DisplayName("")
public class StudentServiceTest {
    StudentService out = new StudentService();

    @DisplayName("Правильная сортировка студентов по их возрасту")
    @Test
    public void test1() {
        //given
        Student value1 = new Student(1l, "Иван", 2);
        Student value2 = new Student(2l, "Илья", 3);
        Student value3 = new Student(3l, "Ваня", 2);
        Student value4 = new Student(4l, "Иля", 3);
        int AGE_ARG = 3;
        Map<Long, Student> expected = new HashMap<>();
        expected.put(2l, value2);
        expected.put(4l, value4);
        out.add(value1);
        out.add(value2);
        out.add(value3);
        out.add(value4);

        //when
        Map<Long, Student> transformedValue = out.getByAge(AGE_ARG);


        //then
        Assertions.assertEquals(expected, transformedValue);

    }
}
