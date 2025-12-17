package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

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
}
