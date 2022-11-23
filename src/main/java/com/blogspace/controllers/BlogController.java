package com.blogspace.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RequestMapping("/blog")
public class BlogController {

    @GetMapping
    public String homePage(){
        return "index";
    }
}
