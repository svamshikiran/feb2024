package com.example.feb2024.service;

import com.example.feb2024.model.Courses;
import com.example.feb2024.repository.CourseRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.query.Update.update;

@Service
public class CoursesService {

    @Autowired
    CourseRespository cRepo;

    public List<Courses> getAllCourses(){
        return cRepo.findAll();
    }

    public void addCourse(Courses course){
        cRepo.save(course);
    }

}
