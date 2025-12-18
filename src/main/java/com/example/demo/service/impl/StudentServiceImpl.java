package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository stdrepo;

    @Override
    public Student poststudent(Student st) {
        return stdrepo.save(st);
    }
    @Override
    public List
}

