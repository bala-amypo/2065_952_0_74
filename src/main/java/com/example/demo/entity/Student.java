package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name should not be blank")
    private String name;

    @NotBlank(message = "Department should not be blank")
    private String dept;

    @Past(message = "DOB must be in the past")
    private LocalDate dob;

    @DecimalMin(value = "6.5", message = "CGPA must be at least 6.5")
    private Double cgpa;

    public Student() {}

    public Student(Long id, String name, String dept, LocalDate dob, Double cgpa) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.dob = dob;
        this.cgpa = cgpa;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDept() { return dept; }
    public void setDept(String dept) { this.dept = dept; }

    public LocalDate getDob() { return dob; }
    public void setDob(LocalDate dob) { this.dob = dob; }

    public Double getCgpa() { return cgpa; }
    public void setCgpa(Double cgpa) { this.cgpa = cgpa; }
}
