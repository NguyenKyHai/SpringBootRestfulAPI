package com.demo.SpringBootAPI.dao;

import com.demo.SpringBootAPI.entity.Student;
import com.demo.SpringBootAPI.repository.IStudentRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentDao implements IStudentDao {
    
    @Autowired
    IStudentRepository repository;
    
    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }
    
    @Override
    public Optional<Student> findById(Long id) {
        return repository.findById(id);
    }
    
    @Override
    public Student save(Student student) {
        return repository.save(student);
    }
    
    @Override
    public void delete(Student student) {
         repository.delete(student);
    }
    
}
