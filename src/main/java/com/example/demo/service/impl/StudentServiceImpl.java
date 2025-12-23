package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;

import com.example.demo.entity.Student;
import com.example.demo.exception.DummyException;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository stdrepo;

    // Only POST operation should be transactional
    @Transactional
    @Override
    public Student addStudent(Student st) {
        // Save the student first
        Student savedStudent = stdrepo.save(st);

        // Example condition to throw an exception
        if ("abcd".equals(st.getName())) {
            throw new DummyException("Testing");
        }

        return savedStudent;
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
        if (stdrepo.existsById(id)) {
            st.setId(id);
            stdrepo.save(st);
            return "Student Updated Successfully";
        } else {
            return "Student with ID " + id + " Not Found";
        }
    }

    @Override
    public String deleteData(Long id) {
        if (stdrepo.existsById(id)) {
            stdrepo.deleteById(id);
            return "Student Deleted Successfully";
        } else {
            return "Student with ID " + id + " Not Found";
        }
    }
}
