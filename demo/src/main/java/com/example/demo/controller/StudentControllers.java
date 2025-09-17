package com.example.demo.controller;
import com.example.demo.DTO.ProductDTO;
import com.example.demo.DTO.StudentDto;
import com.example.demo.Entities.StudentEntites;
import com.example.demo.service.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.GetExchange;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class StudentControllers {
    private StudentServices studentServices;
    @Autowired
    public StudentControllers(StudentServices studentServices){this.studentServices = studentServices;}

    @PostMapping("/students")
    public ResponseEntity<?> addstudent(@RequestBody StudentDto studentDto){
        StudentDto saveddata = studentServices.addStudent(studentDto);
      return  ResponseEntity.status(HttpStatus.CREATED).body(saveddata);
    }

}
