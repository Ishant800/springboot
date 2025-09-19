package com.example.demo.repository;

import com.example.demo.Entities.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepo extends JpaRepository<Courses,Long> {
}
