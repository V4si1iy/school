package ru.hogwarts.school.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.hogwarts.school.model.Faculty;

import java.util.HashMap;
import java.util.Map;

public class FacultyServiceTest {
    FacultyService out = new FacultyService();

    @DisplayName("Правильная сортировка факультетов по их цвету")
    @Test
    public void test1() {
        //given
        Faculty value1 = new Faculty(1l, "Иван", "Белый");
        Faculty value2 = new Faculty(2l, "Илья", "Черный");
        Faculty value3 = new Faculty(3l, "Ваня", "Белый");
        Faculty value4 = new Faculty(4l, "Иля", "Черный");
        String BLACK_ARG = "Черный";
        Map<Long, Faculty> expected = new HashMap<>();
        expected.put(2l, value2);
        expected.put(4l, value4);
        out.add(value1);
        out.add(value2);
        out.add(value3);
        out.add(value4);


        //when
        Map<Long, Faculty> transformedValue = out.getByColor(BLACK_ARG);


        //then
        Assertions.assertEquals(expected, transformedValue);

    }
}
