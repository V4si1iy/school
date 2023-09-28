select student.name, student.age, faculty.name
FROM student
         INNER JOIN faculty on student.faculty_id = faculty.id;
select student.name
FROM student
         inner join avatar a on student.id = a.student_id;