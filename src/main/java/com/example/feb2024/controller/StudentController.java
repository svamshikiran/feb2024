package com.example.feb2024.controller;

import com.example.feb2024.dto.StudentResponseDto;
import com.example.feb2024.model.Student;
import com.example.feb2024.service.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/all")
    public StudentResponseDto getAllStudents(){
        List<Student> studentsList = studentService.getAllStudents();
        StudentResponseDto response = new StudentResponseDto();
        response.setStudentCount(studentsList.size());
        response.setResponseMessage("RETREIVAL SUCCESS");
        response.setStudents(studentsList);
        return response;
    }

    @GetMapping("/get/{rollno}")
    public ResponseEntity<Object> getStudentByRollno(@PathVariable("rollno") int rollno){
        if(rollno <= 0)
            return new ResponseEntity<>("ROLLNO CAN'T BE NEGATIVE, PLEASE TRY AGAIN", HttpStatus.BAD_REQUEST);
        try {
            Student student = studentService.getStudentByRollno(rollno);
            if (student.getRollno() == 0) {
                return new ResponseEntity<>("STUDENT DOESN'T EXIST", HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(student, HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity<>("EXCEPTION OCCURED WHILE PROCESSING, PLEASE CONTACT ADMINISTRATOR/SUPPORT", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/upsert")
    public void addStudent(@RequestBody Student student)throws JsonProcessingException{
        studentService.upsertStudent(student);
    }

    @PutMapping("/update/{rollno}")
    public ResponseEntity<Object> updateStudent(@PathVariable("rollno") int rollno, @RequestBody Student student) throws JsonProcessingException {
        if(!studentService.isStudentPresent(rollno))
            return new ResponseEntity<>("STUDENT DOESN'T EXIST", HttpStatus.BAD_REQUEST);
        else {
            studentService.upsertStudent(student);
            return new ResponseEntity<>("STUDENT RECORD UPDATED", HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{rollno}")
    public void deleteStudent(@PathVariable("rollno") int rollno){
        studentService.deleteStudent(rollno);
    }
}
