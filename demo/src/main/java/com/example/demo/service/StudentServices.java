package com.example.demo.service;
import com.example.demo.DTO.StudentDto;
import com.example.demo.Entities.StudentEntites;
import com.example.demo.repository.StudentRepos;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentServices {
    private StudentRepos studentRepos;

    @Autowired
    public StudentServices(StudentRepos studentRepos){
        this.studentRepos = studentRepos;
    }

    public StudentDto addStudent(StudentDto studentDto){
        if (studentDto.getStudentname() == null || studentDto.getStudentname().isBlank()) {
            throw new IllegalArgumentException("Student name cannot be empty");
        }
        if (studentDto.getStudentemail() == null || !studentDto.getStudentemail().contains("@")) {
            throw new IllegalArgumentException("Invalid student email");
        }
        if (studentDto.getStudentage() == null || studentDto.getStudentage() <= 0) {
            throw new IllegalArgumentException("Age must be greater than 0");
        }


        StudentEntites std = new StudentEntites();
        std.setStudentname(studentDto.getStudentname());
        std.setStudentemail(studentDto.getStudentemail());
        std.setStudentage(studentDto.getStudentage());

        StudentEntites res = studentRepos.save(std);

        StudentDto dto = new StudentDto();
        dto.setStudentname(res.getStudentname());
        dto.setStudentemail(res.getStudentemail());
        dto.setStudentage(res.getStudentage());
        dto.setCreatedAt(res.getCreatedAt());

      return dto;


    }
}
