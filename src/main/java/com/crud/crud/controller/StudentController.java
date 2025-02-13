package com.crud.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.crud.crud.entity.Student;
import com.crud.crud.service.StudentService;

@RestController
@RequestMapping(path = "api/v1/students")

public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping

    public List<Student> getAll(){

        return studentService.getStudents();
    }
    @GetMapping("/{studentId}")

    public Optional<Student> getId (@PathVariable("studentId") Long studentId){

        return studentService.getStudents(studentId);
    }


    @PostMapping
    public void saveUpdate(@RequestBody Student student){

         studentService.saveOrUpdate(student);
    }
    @DeleteMapping("/{studentId}")
    public void saveUpdate(@PathVariable("studentId") Long studentId){

        studentService.delete(studentId);
   }

}
