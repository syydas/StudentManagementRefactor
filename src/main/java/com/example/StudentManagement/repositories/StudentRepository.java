package com.example.StudentManagement.repositories;

import com.example.StudentManagement.entities.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements StudentRepositoryI{
    private List<Student> Students = new ArrayList<>();

    public StudentRepository() {
    }

    public StudentRepository(List<Student> allStudents) {
        this.Students = allStudents;
    }

    public List<Student> getAllStudents() {
        return Students;
    }

    @Override
    public String toString() {
        StringBuilder StudentsString = new StringBuilder();
        for (Student Student : Students) {
            StudentsString.append(Student).append("\n");
        }
        return StudentsString.toString();
    }

    @Override
    public boolean addStudent(Student student) {
        for (Student Student : Students) {
            if (Student.getName().equals(student.getName())) {
                return false;
            }
        }
        Students.add(student);
        return true;
    }

    @Override
    public Student getStudentByName(String name) {
        for (Student student : Students) {
            if (name.equals(student.getName())) {
                return student;
            }
        }
        return new Student();
    }

    @Override
    public boolean deleteStudentByName(String name) {
        Student deleteStudent = new Student();
        for (Student student : Students) {
            if (student.getName().equals(name)) {
                deleteStudent = student;
                break;
            }
        }
        return Students.remove(deleteStudent);
    }
}
