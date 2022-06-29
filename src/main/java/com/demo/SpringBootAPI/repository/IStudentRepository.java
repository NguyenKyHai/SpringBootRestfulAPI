package com.demo.SpringBootAPI.repository;

import com.demo.SpringBootAPI.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IStudentRepository extends JpaRepository<Student, Long>{
    
}
