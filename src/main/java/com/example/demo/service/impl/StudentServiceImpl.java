package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository stdrepo;

    // POST operation with @Transactional
    @Transactional
    @Override
    public Student addStudent(Student st) {
        return stdrepo.save(st);
    }

    // GET all students
    @Override
    public List<Student> getAllStudents() {
        return stdrepo.findAll();
    }

    // GET student by ID
    @Override
    public Optional<Student> getStudentById(Long id) {
        return stdrepo.findById(id);
    }

    // UPDATE student
    @Transactional
    @Override
    public String updateStudent(Long id, Student st) {
        boolean exists = stdrepo.existsById(id);
        if (exists) {
            st.setId(id);
            stdrepo.save(st);
            return "Student Updated Successfully";
        } else {
            return "Student with ID " + id + " Not Found";
        }
    }

    // DELETE student
    @Transactional
    @Override
    public String deleteData(Long id) {
        boolean exists = stdrepo.existsById(id);
        if (exists) {
            stdrepo.deleteById(id);
            return "Student Deleted Successfully";
        } else {
            return "Student with ID " + id + " Not Found";
        }
    }
}
