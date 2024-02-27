package com.example.feb2024.repository;

import com.example.feb2024.model.Student;
import jakarta.persistence.NamedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    public List<Student> findByName(String name);

    public List<Student> findByCity(String city);

    public List<Student> findByNameAndCity(String name, String City);
    //select * from student where name=? and city=?

    public List<Student> findByNameOrCity(String name, String City);
    //select * from student where name=? or city=?

    /*
    @Query(name = "select", nativeQuery = true)
    public List<Student> query(String name, String City);
    //select * from student where name=? and city=?

     */
}
