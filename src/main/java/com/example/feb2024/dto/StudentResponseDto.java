package com.example.feb2024.dto;

import com.example.feb2024.model.Student;

import java.util.List;

public class StudentResponseDto {

    private int studentCount;
    private String responseMessage;
    private List<Student> students;

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
