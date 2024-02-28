package com.example.feb2024.controller;

import com.example.feb2024.model.Courses;
import com.example.feb2024.service.CoursesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CoursesController {

    private static Logger log = LoggerFactory.getLogger(CoursesController.class);

    @Autowired
    CoursesService cService;

    @GetMapping("/all")
    public List<Courses> getAllCourses(){
        log.info("I am here in the Courses Controller");
        return cService.getAllCourses();
    }

    @PostMapping("/add")
    public void addCourse(@RequestBody Courses course){
        cService.addCourse(course);
    }

}
