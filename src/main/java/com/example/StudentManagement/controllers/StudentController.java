package com.example.StudentManagement.controllers;

import com.example.StudentManagement.entities.Student;
import com.example.StudentManagement.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController{

    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping("/addStudentsByName")
    public String addStudentsByName(@RequestBody Student student) {
        Student s = studentService.getStudentsByName(student.getName());
        if (s != null){
            return "姓名重复";
        }else {
            studentService.addStudentsByName(student);
            return "添加成功";
        }
    }

    @GetMapping("/getAllStudents")
    public String getAllStudents() {
        return studentService.getAllStudents().toString();
    }

    @PostMapping("/getStudentsByName")
    public String getStudentsByName(@RequestBody String name) {
        Student student = studentService.getStudentsByName(name);
        if (student != null){
            return  student.toString();
        }else {
            return "找不到该学生";
        }
    }

    @PostMapping("/deleteStudentsByName")
    public String deleteStudentsByName(@RequestBody String name) {
        if (0 == studentService.deleteStudentsByName(name)) {
            return "该学生不存在";
        } else {
            return "删除成功";
        }

    }
}