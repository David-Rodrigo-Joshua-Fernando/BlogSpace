package com.blogspace.controllers;

import com.blogspace.models.Blog;
import com.blogspace.repositories.BlogRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/blogs")
public class BlogController {


//    DAO
    private final BlogRepository blogDao;

    public BlogController(BlogRepository blogDao){
        this.blogDao = blogDao;
    }



    @GetMapping("/blog")
    public String homePage(){
        return "blogs/blog";
    }





    //    Creates new post
    @PostMapping("/blog")
//    This is the one that sends you to the all-post
    public  String createPost(@RequestParam(name = "genre") String genre, @RequestParam(name = "title") String title){
        Blog post = new Blog(title,genre);
        blogDao.save(post);
        return "/blogs/blog";
    }


} // End of BlogController
