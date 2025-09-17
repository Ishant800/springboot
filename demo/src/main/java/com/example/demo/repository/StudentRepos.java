package com.example.demo.repository;

import com.example.demo.Entities.StudentEntites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepos extends JpaRepository<StudentEntites, Long>{

}
                                                                               