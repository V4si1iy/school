package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.hogwarts.school.model.Student;

import java.util.List;

@Repository

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query(value = "SELECT count(*) AS count FROM student", nativeQuery = true)
    Long getCountStudent();

    @Query(value = "select avg(age) AS AverageAge from student", nativeQuery = true)
    Long getAverageAge();

    @Query(value = "select * FROM student order by id desc limit 5", nativeQuery = true)
    List<Student> getLastFiveStudent();

    List<Student> findByAge(int student);

    List<Student> findByAgeBetween(int ageMin, int ageMax);

    List<Student> findByFaculty_Id(long id);


}
