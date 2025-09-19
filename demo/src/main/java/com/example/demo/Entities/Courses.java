package com.example.demo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    private String title;
    @Column(name = "course_desc")
    private String desc;

    @ManyToMany(mappedBy = "courses")
    @JsonIgnoreProperties("student")
    private Set<StudentEntites> student = new HashSet<>();


    public Courses(){}
    public Courses(Long courseId,String title,String desc){
        this.title = title;
        this.desc = desc;
        this.courseId = courseId;
    }

    public Long getCourseId() {return courseId;}
    public void setCourseId(Long courseId) {this.courseId = courseId;}

    public String getTitle(){return title;}
    public void setTitle(String title) {this.title = title;}

    public String getDesc(){return desc;}
    public void setDesc(String desc){this.desc = desc;}

    public Set<StudentEntites> getStudent() {
        return student;
    }

    public void setStudent(Set<StudentEntites> student) {
        this.student = student;
    }
}
