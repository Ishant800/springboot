package com.example.demo.repository;

import com.example.demo.Entities.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Long> {
    //derived query methods
    //afai query generate huncha yesma'
    List<Blog> findByAuthor(String author);
    List<Blog> findByTitleContaining(String keyword);
    //sorting
    List<Blog> findAllByOrderByTitleAsc();
    List<Blog> findByAuthorAndTitle(String author,String title);



//    List<Blog> findBlogsByAuthorJPQL

}

