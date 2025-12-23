package com.example.demo.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService stdser;

    @PostMapping("/add")
    public Student addStudent(@Valid @RequestBody Student st) {
        return stdser.addStudent(st);
    }

    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return stdser.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return stdser.getStudentById(id);
    }

    @PutMapping("/update/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student st) {
        return stdser.updateStudent(id, st);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        stdser.deleteData(id);
        return "Student deleted successfully";
    }
}
