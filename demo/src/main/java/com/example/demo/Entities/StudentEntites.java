package com.example.demo.Entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "student")
public class StudentEntites {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentname;
    private int studentage;
    private String studentemail;

    @CreationTimestamp
    @Column(name = "created_at",nullable = false,updatable = false)
    private LocalDateTime createdAt;

    public StudentEntites(){}
    public StudentEntites(String studentname ,int studentage ,String studentemail){
        this.studentname = studentname;
        this.studentage = studentage;
        this.studentemail = studentemail;
    }

    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}

    public String getStudentname(){return studentname;}
    public void setStudentname(String studentname){this.studentname=studentname;}


    public int getStudentage(){return studentage;}
    public void setStudentage(int studentage){this.studentage=studentage;}

    public String getStudentemail(){return studentemail;}
    public void setStudentemail(String studentemail){this.studentemail=studentemail;}

    public LocalDateTime getCreatedAt(){return createdAt;}
    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt = createdAt;
    }
}
