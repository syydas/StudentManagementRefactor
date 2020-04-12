package com.example.StudentManagement.entities;

public class Student {
    private String name;
    private String gender;
    private String classNum;

    public Student() {
    }

    public Student(String name, String gender, String classNum) {
        this.name = name;
        this.gender = gender;
        this.classNum = classNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", classNum='" + classNum + '\'' +
                '}';
    }
}
