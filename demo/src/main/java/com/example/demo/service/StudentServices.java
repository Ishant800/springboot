package com.example.demo.service;
import com.example.demo.DTO.StudentDto;
import com.example.demo.Entities.Courses;
import com.example.demo.Entities.StudentEntites;
import com.example.demo.repository.CoursesRepo;
import com.example.demo.repository.StudentRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServices {
    private StudentRepos studentRepos;
    private CoursesRepo coursesRepo;


    public StudentServices(StudentRepos studentRepos,CoursesRepo coursesRepo){

        this.studentRepos = studentRepos;
        this.coursesRepo = coursesRepo;
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

    public StudentEntites createStudent(StudentEntites studentEntites){
        return studentRepos.save(studentEntites);
    }

    public Courses createCourses(Courses course){
        return coursesRepo.save(course);
    }

    public String enrollcourse(Long studentId,Long courseId){
        Optional<StudentEntites> studentOpt = studentRepos.findById(studentId);
        Optional<Courses> coursesOptional = coursesRepo.findById(courseId);

        if(studentOpt.isEmpty()) return "student not found";
        if(coursesOptional.isEmpty()) return "courses not found";

        StudentEntites student = studentOpt.get();
        Courses course = coursesOptional.get();


        student.enrollCourse(course);
        studentRepos.save(student);

        return "student enrolled sucessfully";
    }

    public List<StudentEntites> getAllStudent(){
        return studentRepos.findAll();
    }

    public List<Courses> getAllCourse(){
        return coursesRepo.findAll();
    }


}
