package com.example.demo.Entities;

import jakarta.persistence.*;
//model table details and table creating
@Entity
@Table(name = "student")
public class StudentsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(name = "student_name",nullable = false)
    public String name;
    @Column(unique = true,nullable = true)
    public String email;
    @Column(nullable = false)
    public String address;

    //manual getters//setters
    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}

    public String getName(){return  name;}
    public void setName(String name){this.name=name;}

    public String getEmail(){return email;}
    public void setEmail(String email){this.email = email;}

    public String getAddress(){return address;}
    public void setAddress(String address){this.address = address;}
}
