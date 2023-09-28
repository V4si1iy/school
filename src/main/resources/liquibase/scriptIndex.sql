--liquibase formatted sql
--changeset Vasiliy:1
CREATE INDEX student_name ON student (name);

-- changeset Vasiliy:2
CREATE INDEX faculty_name_color ON faculty(name,color)