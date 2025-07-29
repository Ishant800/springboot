package com.example.demo.controller;

import com.example.demo.DTO.StudentDto;
import com.example.demo.Entities.StudentsEntity;
import com.example.demo.service.StudentService;
import com.zaxxer.hikari.util.IsolationLevel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/students")
public class StudentControllers {
    private final StudentService studentService;
    //constructor
    public StudentControllers(StudentService studentService){this.studentService = studentService;}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)//res.statud(200)
    public StudentsEntity create(@RequestBody StudentsEntity students){
        return studentService.createStudent(students);
    }
    @PostMapping("/Studentapi")
    //student create api
    public ResponseEntity<String> signup(@RequestBody StudentDto request){
        try{
            String message = studentService.singnup(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(message);
        }
        catch(IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong");
        }
    }

    //students details update
    @PostMapping("/{id}")
    public ResponseEntity<String> updateStudentdetails(@PathVariable Long id,@RequestBody StudentDto req){
        try{
            String message = studentService.updateStudent(id,req);
            return ResponseEntity.ok(message);
        }
        catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    //students details
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        try{
            String message = studentService.deleteStudent(id);
            return ResponseEntity.ok(message);
        }
        catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @GetMapping
    public List<StudentsEntity> getAll(){
        return studentService.getAllStudents();//res.json
    }

    @GetMapping("/{id}")
   public ResponseEntity<?> getStudentById(@PathVariable Long id){
        try{
            StudentDto response = studentService.getStudentById(id);
            return ResponseEntity.ok(response);
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
