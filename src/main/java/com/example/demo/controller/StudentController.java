package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import com.example.demo.service.StudentService;
import com.example.demo.entity.Student;

@RestController
public class StudentController {

    @Autowired
    StudentService stdser;

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student st) {
        return stdser.poststudent(st);
    }

    @GetMapping("/getall")
    public List<Student> get() {
        return stdser.getAllStudents();
    }

    @GetMapping("/getById/{id}")
    public Optional<Student> getId(@PathVariable Long id) {
        return stdser.getById(id);
    }
    @PutMapping("/update/{id}")
    public String update(@PathVariable Long id,@RequestBody Student st){
        return stdsre.updateData(id,st);
    } 
}
