package com.example.demo.service;

import com.example.demo.DTO.StudentDto;
import com.example.demo.Entities.StudentsEntity;
import com.example.demo.repository.StudentRepo;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
   private final StudentRepo studentRepo;
   //constructor dependency
    public StudentService(StudentRepo studentRepo){this.studentRepo = studentRepo;}

    //create api
    public StudentsEntity createStudent(StudentsEntity students){

        return studentRepo.save(students);
    }

//students create api
    public String singnup(StudentDto request){
        if(request.getName() == null || request.getName().isEmpty() ||
             request.getEmail()  == null || request.getEmail().isEmpty() ||
                request.getAddress() == null || request.getAddress().isEmpty() ){
            throw new IllegalArgumentException("all fields are necessary");
        }
        if(studentRepo.findByEmail(request.getEmail()).isPresent()){
            throw  new IllegalArgumentException("user already exists");
        }

        StudentsEntity std = new StudentsEntity();
        std.setName(request.getName());
        std.setEmail(request.getEmail());
        std.setAddress(request.getAddress());

        StudentsEntity saveduser = studentRepo.save(std);


        return "student created" + saveduser;
    }



    //update api
    public String updateStudent(Long id,StudentDto req){
        StudentsEntity students = studentRepo.findById(id).orElseThrow(()->new IllegalArgumentException("student not found"));

        students.setName(req.getName());
        students.setEmail(req.getEmail());
        students.setAddress(req.getAddress());

        studentRepo.save(students);
        return "students update sucessfully";
    }

    //students delete api
    public String deleteStudent(Long id){
        if(!studentRepo.existsById(id)){
            throw new IllegalArgumentException("students not found");
        }
        studentRepo.deleteById(id);
        return "student delete sucessfully";
    }

    //read all
    public List<StudentsEntity> getAllStudents(){
        return studentRepo.findAll();
    }

    //read one
   public StudentDto getStudentById(Long id){
        StudentsEntity students = studentRepo.findById(id).orElseThrow(()->new IllegalArgumentException("student not found"));

        return new StudentDto(
          students.getId(),
                students.getName(),
                students.getEmail(),
                students.getAddress()

        );
   }
}
