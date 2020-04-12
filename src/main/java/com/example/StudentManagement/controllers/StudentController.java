package com.example.StudentManagement.controllers;

import com.example.StudentManagement.entities.Student;
import com.example.StudentManagement.repositories.StudentRepository;
import com.example.StudentManagement.repositories.StudentRepositoryI;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class StudentController {
    StudentRepositoryI students = new StudentRepository(new ArrayList<Student>() {
        {
            add(new Student("阿苏", "女", "1-1"));
            add(new Student("小赞", "男", "1-2"));
            add(new Student("椰波", "男", "1-2"));
            add(new Student("洲洲", "男", "1-3"));
            add(new Student("鲸鱼", "男", "1-3"));
        }
    });

    @PostMapping("/addStudents")
    public String addStudents(@RequestBody Student student) {
        if (students.addStudent(student)) {
            return "添加成功";
        } else {
            return "姓名重复";
        }
    }

    @GetMapping("/getAllStudents")
    public String getAllStudents() {
        return students.toString();
    }

    @PostMapping("/getStudentsByName")
    public String getStudentsByName(@RequestBody String name) {
        Student student = students.getStudentByName(name);
        if (null == student.getName()) {
            return "该学生不存在";
        } else {
            return student.toString();
        }
    }

    @PostMapping("/deleteStudentsByName")
    public String deleteStudentsByName(@RequestBody String name) {
        if (students.deleteStudentByName(name)) {
            return "删除成功";
        } else {
            return "该学生不存在";
        }
    }
}
