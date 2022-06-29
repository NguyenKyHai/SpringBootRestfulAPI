
package com.demo.SpringBootAPI.dao;

import com.demo.SpringBootAPI.entity.Student;
import java.util.List;
import java.util.Optional;

public interface IStudentDao {
    List<Student>findAll();
    Optional<Student> findById(Long id);
    Student save(Student student);
    void delete(Student student);
}
