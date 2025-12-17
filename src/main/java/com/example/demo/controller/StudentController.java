package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.service.StudentService;
import com.example.demo.entity.Student;

@RestController
public class StudentController{
    @Autowired
    StudentService stdser;

     @PosttMapping("/addStudent")
     public Student addStudent(@RequestBody Student st){
          retrun stdser.poststudent(st);
     }
}