package com.blogspace.controllers;

import com.blogspace.models.Blog;
import com.blogspace.models.User;
import com.blogspace.repositories.BlogRepository;
import com.blogspace.services.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
        return "blog";
    }


    @GetMapping("/create")
    public String showCreateBlog(){
        return "/create";
    }

    @PostMapping("/create")
    public String submitCreateForm(@ModelAttribute Blog blog){
        User user = Utils.currentUser();
        blog.setUser(user);
        blogDao.save(blog);
        return "redirect:/blogs";
    }


}