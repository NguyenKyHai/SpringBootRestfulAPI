package com.demo.SpringBootAPI.controller;

import com.demo.SpringBootAPI.dao.StudentDao;
import com.demo.SpringBootAPI.entity.Student;
import com.demo.SpringBootAPI.response.ResponseMessage;
import com.sun.xml.internal.messaging.saaj.client.p2p.HttpSOAPConnectionFactory;
import java.security.cert.PKIXRevocationChecker;
import java.util.List;
import java.util.Optional;
import javax.xml.ws.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    StudentDao studentDao;

    @PostMapping()
    public ResponseEntity<?> createStudent(@RequestBody Student student) {
        if (student.getName().trim().isEmpty()) {
            return new ResponseEntity<>(new ResponseMessage("The name is required!"), HttpStatus.OK);
        }
        studentDao.save(student);
        return new ResponseEntity<>(new ResponseMessage("Create Student successfully"), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getListStudent() {
        List<Student> students = studentDao.findAll();
        if (students.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Optional<Student> student1 = studentDao.findById(id);
        if (!student1.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (student.getName().trim().isEmpty()) {
            return new ResponseEntity<>(new ResponseMessage("The name is required!"), HttpStatus.OK);
        }
        student1.get().setName(student.getName());
        studentDao.save(student1.get());
        return new ResponseEntity<>(new ResponseMessage("Updated successfully!"), HttpStatus.OK);
    }
    
    @GetMapping("{id}")
    public ResponseEntity<?>detailStudent(@PathVariable Long id){
        Optional<Student> student=studentDao.findById(id);
           if (!student.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student,HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?>deleteStudent(@PathVariable Long id){
        Optional<Student>student=studentDao.findById(id);
        if (!student.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        studentDao.delete(student.get());
        return new ResponseEntity<>(new ResponseMessage("Deleted Successfully!"),HttpStatus.OK);
    }
    
}
