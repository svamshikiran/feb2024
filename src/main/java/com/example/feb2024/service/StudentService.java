package com.example.feb2024.service;

import com.example.feb2024.model.Student;
import com.example.feb2024.repository.StudentRepository;
import org.apache.catalina.valves.StuckThreadDetectionValve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
        //prepare the query select * from student;
        //execute the query and get the result set
        //map each record in the result set to the student object
        //add the student object to the list.
    }

    public Student getStudentByRollno(int rollno){
        Optional<Student> optionalStudent = studentRepository.findById(rollno);
        //select * from student where rollno=?
        if(optionalStudent.isEmpty())
            return new Student();
        else
            return optionalStudent.get();
    }

    public boolean isStudentPresent(int rollno){
        return studentRepository.findById(rollno).isPresent();
    }

    public void upsertStudent(Student student){
        studentRepository.save(student);
        //insert or update
    }

    public void deleteStudent(int rollno){
        studentRepository.deleteById(rollno);
    }
}
