package com.blogspace.controllers;

import com.blogspace.models.Blog;
import com.blogspace.repositories.BlogRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    private final BlogRepository blogDao;

    public BlogController(BlogRepository blogDao){
        this.blogDao = blogDao;
    }

    @GetMapping
    public String homePage(){
        return "index";
    }
}
