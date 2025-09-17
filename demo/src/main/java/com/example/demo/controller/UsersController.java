package com.example.demo.controller;
import com.example.demo.DTO.UsersDto;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UsersController {
@Autowired
    private EmployeeService employeeService;

    @PostMapping
    public String addUser(@RequestParam String name,@RequestParam String email,@RequestParam Integer age){
        employeeService.insertEmployee(name,email,age);
        return "users add sucessfully";
    }
    @PostMapping("/adduser")
    public String insertUser(@RequestBody UsersDto usersDto){
        employeeService.insertEmployee(usersDto.getName(),usersDto.getEmail(),usersDto.getAge());
    return "user created sucessfully";
    }

    @GetMapping
    public List<Map<String ,Object>> getAllUsers(){return employeeService.getAllUsers();}

    @GetMapping("/{id}")
    public Map<String,Object> getUsersById(@PathVariable int id){
        return employeeService.getUserById(id);
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable int id, @RequestParam String name){
        employeeService.updateUsers(id,name);
        return "users update sucessfully";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id){
        employeeService.deleteUsers(id);
        return "User deleted sucessfully";
    }

    @PostMapping("/addemployee")
    public String addEmployee(@RequestParam String name,
                              @RequestParam String email,
                              @RequestParam int age){
        employeeService.addEmployee(name,email,age);
        return "employee created sucessfully";
    }
}
