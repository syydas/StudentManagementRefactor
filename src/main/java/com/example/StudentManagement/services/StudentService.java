package com.example.StudentManagement.services;

import com.example.StudentManagement.entities.Student;
import com.example.StudentManagement.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class StudentService {
    @Autowired
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addStudentsByName(@RequestBody Student student) {
       studentRepository.save(student);
    }

    public Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentsByName(@RequestBody String name) {
        return studentRepository.getStudent(name);
    }

    public int deleteStudentsByName(@RequestBody String name) {
        return studentRepository.deleteStudentByName(name);
    }
}
