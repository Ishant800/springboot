package com.example.demo.controller;
import com.example.demo.DTO.ProductDTO;
import com.example.demo.DTO.StudentDto;
import com.example.demo.Entities.Courses;
import com.example.demo.Entities.StudentEntites;
import com.example.demo.service.StudentServices;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.GetExchange;
import java.util.List;
import java.util.Set;

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

    @PostMapping("/addstudents")
    public ResponseEntity<StudentEntites> createSTudnet(@RequestBody StudentEntites studentEntites){
        return ResponseEntity.ok(studentServices.createStudent(studentEntites));
    }

    @PostMapping("/addcourse")
    public ResponseEntity<Courses> createCourse(@RequestBody Courses courses){
        return ResponseEntity.ok(studentServices.createCourses(courses));
    }

    @PostMapping("/{studentId}/courses/{courseId}")
    public ResponseEntity<String> enrollCourse(@PathVariable Long studentId,@PathVariable Long courseId){
        return ResponseEntity.ok(studentServices.enrollcourse(studentId,courseId));
    }

    @GetMapping("/allstudents")
    public ResponseEntity<List<StudentEntites>> getall(){
       return ResponseEntity.ok(studentServices.getAllStudent());
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Courses>> getallCourses(){
        return ResponseEntity.ok(studentServices.getAllCourse());
    }

}
