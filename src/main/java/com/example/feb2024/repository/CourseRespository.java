package com.example.feb2024.repository;

import com.example.feb2024.model.Courses;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRespository extends MongoRepository<Courses, Integer> {
}
