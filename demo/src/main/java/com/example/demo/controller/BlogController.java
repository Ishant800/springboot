package com.example.demo.controller;

import com.example.demo.DTO.BlogDto;
import com.example.demo.Entities.Blog;
import com.example.demo.service.BlogService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {
    private BlogService blogService;
    public BlogController(BlogService blogService){
        this.blogService = blogService;
    }

    @PostMapping
    public Blog createBlog(@RequestBody Blog blog){
        return blogService.saveBlog(blog);
    }

    @PostMapping("/addblog")
    public ResponseEntity<?> addBlog(@Valid @RequestBody BlogDto blogDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            List<String> errors = bindingResult.getFieldErrors().stream().map(error-> error.getField() + " : " + error.getDefaultMessage()).toList();
        return ResponseEntity.badRequest().body(errors);
        }
        BlogDto savedBlog = blogService.addBlog(blogDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBlog);
    }

    @GetMapping
    public ResponseEntity<List<BlogDto>> getBlogs() {
        List<BlogDto> blogs = blogService.getAllBlogs();  // no .getBody()
        return ResponseEntity.ok(blogs);
    }


    @GetMapping("/{id}")
    public Blog getBlogById(@PathVariable Long id){
        return blogService.getBlog(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBlog(@PathVariable Long id){
        blogService.deleteByid(id);
    }

    @GetMapping("/author/{author}")
    public List<Blog> getByAutor(@PathVariable String author){
        return blogService.getBlogsByAuthor(author);
    }
}
