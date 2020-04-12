package com.example.StudentManagement.repositories;

import com.example.StudentManagement.entities.Student;

public interface StudentRepositoryI {
    boolean addStudent(Student student);
    Student getStudentByName(String name);
    boolean deleteStudentByName(String name);
}
