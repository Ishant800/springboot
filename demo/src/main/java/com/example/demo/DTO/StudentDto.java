package com.example.demo.DTO;

import java.time.LocalDateTime;

public class StudentDto {
    private String  studentname;
    private String  studentemail;
    private Integer studentage;
    private LocalDateTime createdAt;

    public StudentDto(String studentname,String studentemail, Integer studentage,LocalDateTime createdAt){
        this.studentage = studentage;
        this.studentname = studentname;
        this.studentemail = studentemail;
        this.createdAt = createdAt;

    }

    public StudentDto() {

    }

    public String getStudentname() {return studentname;}
    public void setStudentname(String studentname){this.studentname = studentname;}

    public String getStudentemail(){return studentemail;}
    public void setStudentemail(String studentemail) {this.studentemail = studentemail;}

    public Integer getStudentage(){return studentage;}
    public void setStudentage(Integer studentage) {this.studentage = studentage;}

    public LocalDateTime getCreatedAt(){return createdAt;}
    public void setCreatedAt(LocalDateTime createdAt){this.createdAt = createdAt;}
}
