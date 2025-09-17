package com.example.demo.repository;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class Userrepository {
    private final NamedParameterJdbcTemplate jdbc;
    public Userrepository(NamedParameterJdbcTemplate jdbc){
        this.jdbc = jdbc;
    }

//    public int insertUser(String name,String email, int age){
//        String sql = "INSERT INTO users(name,email,age) VALUES(:name,:email,:age)";
//
//    }

}
