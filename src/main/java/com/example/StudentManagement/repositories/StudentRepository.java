package com.example.StudentManagement.repositories;

import com.example.StudentManagement.entities.Student;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface StudentRepository extends CrudRepository<Student, Integer> {

    @Query("SELECT id,name,gender,class_number FROM student where name=:name ")
    Student getStudent(@Param("name") String name);

    @Modifying
    @Query("DELETE FROM student WHERE name=:name")
    int deleteStudentByName(@Param("name") String name);
}