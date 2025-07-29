package com.example.demo.repository;

import com.example.demo.Entities.StudentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepo extends JpaRepository<StudentsEntity,Long> {
 Optional<StudentsEntity> findByEmail(String email);
 boolean existsByEmail(String email);
}
