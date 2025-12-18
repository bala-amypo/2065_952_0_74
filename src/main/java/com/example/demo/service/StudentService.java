package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import com.example.demo.entity.Student;

public interface StudentService {

    Student addStudent(Student student);

    List<Student> getAllStudents();

    Optional<Student> getStudentById(Long id);

    String updateStudent(Long id, Student student);
}
