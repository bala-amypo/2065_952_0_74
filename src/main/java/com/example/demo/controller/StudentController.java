package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import jakarta.validation.Valid;

import com.example.demo.service.StudentService;
import com.example.demo.entity.Student;

@RestController
public class StudentController {

    @Autowired
    StudentService stdser;

    @PostMapping("/addStudent")
    public Student addStudent(@Valid @RequestBody Student st) {
        return stdser.addStudent(st);
    }

    @GetMapping("/getall")
    public List<Student> get() {
        return stdser.getAllStudents();
    }

    @GetMapping("/getById/{id}")
    public Optional<Student> getId(@PathVariable Long id) {
        return stdser.getStudentById(id);
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable Long id, @RequestBody Student st) {
        return stdser.updateStudent(id, st);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return stdser.deleteData(id);
    }
}
