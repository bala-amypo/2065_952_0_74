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

    // POST: Add new student
    @PostMapping("/add")
    public Student addStudent(@Valid @RequestBody Student st) {
        return stdser.addStudent(st);
    }

    // GET: All students
    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return stdser.getAllStudents();
    }

    // GET: Student by ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return stdser.getStudentById(id).orElse(null);
    }

    // PUT: Update student
    @PutMapping("/update/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student st) {
        String result = stdser.updateStudent(id, st);
        if (result.contains("Not Found")) {
            return null;
        }
        return st; // Return the updated student
    }

    // DELETE: Delete student
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        return stdser.deleteData(id);
    }
}
