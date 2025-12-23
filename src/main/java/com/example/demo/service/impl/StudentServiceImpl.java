package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository stdrepo;

    @Transactional
    @Override
    public Student addStudent(Student st) {
        return stdrepo.save(st);
        throw new DummyException(msg: "Testing");
    }

    @Override
    public List<Student> getAllStudents() {
        return stdrepo.findAll();
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return stdrepo.findById(id);
    }

    @Override
    public String updateStudent(Long id, Student st) {
        boolean status = stdrepo.existsById(id);
        if (status) {
            st.setId(id);
            stdrepo.save(st);
            return "Student Updated Successfully";
        } else {
            return "Student with ID " + id + " Not found";
        }
    }

    @Override
    public String deleteData(Long id) {
        boolean status = stdrepo.existsById(id);
        if (status) {
            stdrepo.deleteById(id);
            return "Student Deleted Successfully";
        } else {
            return "Student with ID " + id + " Not Found";
        }
    }
}
