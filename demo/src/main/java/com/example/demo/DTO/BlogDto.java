package com.example.demo.DTO;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;

public class BlogDto {
private Long id;

@NotBlank(message = "authors are required ")
@Size(min = 3 ,message = "title must be at least 3 character")
private String author;

@NotBlank(message = "title are required")
private String title;

@NotBlank(message = "content are required")
private String content;


public BlogDto(){}
    public BlogDto(Long id,String author,String title,String content){
    this.id = id;
    this.author = author;
    this.title = title;
    this.content = content;
    }

    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}

    public String getTitle(){return title;}
    public void setTitle(String title){this.title = title;}

    public String getAuthor(){return author;}
    public void setAuthor(String author){this.author = author;}

    public String getContent(){return content;}
    public void setContent(String content){this.content = content;}
}
