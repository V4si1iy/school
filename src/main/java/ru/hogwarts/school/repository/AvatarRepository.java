package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hogwarts.school.model.Avatar;
import ru.hogwarts.school.model.Student;

@Repository
public interface AvatarRepository extends JpaRepository<Avatar, Long> {
    Avatar findByStudent(Student student);
}
