package com.blogspace.controllers;

import com.blogspace.models.Blog;
import com.blogspace.repositories.BlogRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    private final BlogRepository blogDao;

    public BlogController(BlogRepository blogDao){
        this.blogDao = blogDao;
    }

    @GetMapping
    public String homePage(Model model){
        List<Blog> allBlogs = blogDao.findAll();
        model.addAttribute("allBlogs", allBlogs);
        return "index";
    }

    @GetMapping("/create")
    public String showCreateBlog(){
        return "/create";
    }


}
