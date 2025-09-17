package com.example.demo.service;

import com.example.demo.DTO.BlogDto;
import com.example.demo.Entities.Blog;
import com.example.demo.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    private BlogRepository repo;
//    private CategoryRepository categoryRepository;

    @Autowired
    public BlogService(BlogRepository repo){
        this.repo = repo;

    }

    public BlogDto addBlog(BlogDto dto){
        Blog blog = new Blog();
        blog.setId(dto.getId());
        blog.setTitle(dto.getTitle());
        blog.setAuthor(dto.getAuthor());
        blog.setContent(dto.getContent());
        Blog savedBlog = repo.save(blog);

        return new BlogDto(savedBlog.getId(),savedBlog.getAuthor(),savedBlog.getTitle(),savedBlog.getContent());
    }

    //list all blogs
    public List<BlogDto> getAllBlogs() {
        return repo.findAll()
                .stream()
                .map(b -> new BlogDto(
                        b.getId(),
                        b.getAuthor(),
                        b.getTitle(),
                        b.getContent()))
                .toList();
    }

    //create a blogs
    public Blog saveBlog(Blog blog){

        return repo.save(blog);
    }

    //get all bogs
    public List<Blog> getAllBlog(){
        return repo.findAll();
    }
    //get blog byid
    public Blog getBlog(Long id){
        return repo.findById(id).orElseThrow();
    }

    //delete blog by id
    public void deleteByid(Long id){
         repo.deleteById(id);
    }

    public List<Blog> getBlogsByAuthor(String author){
        return repo.findByAuthor(author);
    }
}
