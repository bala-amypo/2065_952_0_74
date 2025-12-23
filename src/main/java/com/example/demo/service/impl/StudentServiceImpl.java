package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import com.example.demo.entity.Student;
import com.example.demo.exception.DummyException;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository stdrepo;

    @Transactional
    @Override
    public Student addStudent(Student st) {
        return stdrepo.save(st);
    }

    @Override
    public List<Student> getAllStudents() {
        return stdrepo.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return stdrepo.findById(id)
                .orElseThrow(() -> new DummyException("Student not found with id " + id));
    }

    
    @Override
    public Student updateStudent(Long id, Student st) {
        if (stdrepo.existsById(id)) {
            st.setId(id);
            return stdrepo.save(st);
        } else {
            throw new DummyException("Student not found with id " + id);
        }
    }

    
    @Override
    public void deleteData(Long id) {
        if (stdrepo.existsById(id)) {
            stdrepo.deleteById(id);
        } else {
            throw new DummyException("Student not found with id " + id);
        }
    }
}
