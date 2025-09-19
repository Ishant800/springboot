package com.example.demo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student")
public class StudentEntites {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "student_name")
    private String studentname;
    @Column(name = "student_age")
    private int studentage;
    @Column(name = "student_email")
    private String studentemail;

    @CreationTimestamp
    @Column(name = "created_at",nullable = false,updatable = false)
    private LocalDateTime createdAt;

    @ManyToMany
    @JoinTable(
             name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns =  @JoinColumn(name = "course_id")
    )
    @JsonIgnoreProperties("courses")
    private Set<Courses> courses = new HashSet<>();

    public StudentEntites(){}
    public StudentEntites(Long studentId, String studentname ,int studentage ,String studentemail){
        this.studentId = studentId;
        this.studentname = studentname;
        this.studentage = studentage;
        this.studentemail = studentemail;

    }

    public Long getStudentId(){return studentId;}
    public void setStudentId(Long studentId){this.studentId = studentId;}

    public String getStudentname(){return studentname;}
    public void setStudentname(String studentname){this.studentname=studentname;}


    public int getStudentage(){return studentage;}
    public void setStudentage(int studentage){this.studentage=studentage;}

    public String getStudentemail(){return studentemail;}
    public void setStudentemail(String studentemail){this.studentemail=studentemail;}

    public LocalDateTime getCreatedAt(){return createdAt;}
    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt = createdAt;
    }

    public Set<Courses> getCourses(){return courses;}

    public void setCourses(Set<Courses> courses) {
        this.courses = courses;
    }


    public void enrollCourse(Courses course){
        courses.add(course);
        course.getStudent().add(this);
    }

    public void removeCourse(Courses course){
        courses.remove(course);
        course.getStudent().remove(this);

    }
}
