package com.blogspace.controllers;

import com.blogspace.models.Blog;
import com.blogspace.models.User;
import com.blogspace.repositories.BlogRepository;
import com.blogspace.repositories.UserRepository;
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

    private final UserRepository userDao;

    public BlogController(BlogRepository blogDao, UserRepository userDao) {
        this.blogDao = blogDao;
        this.userDao = userDao;
    }

    //    This shows you all your post
    @GetMapping
    public String homePage(Model model){
        List<Blog> blogs = blogDao.findAll();
        model.addAttribute("blogs", blogs);
        return "blog";
    }



    //    Takes me to the create.html which is main page that says Create your post
    @GetMapping("/create")
    public String homepageBlog(Model model){
        List<User>users = userDao.findAll();
        model.addAttribute("users", users);
        model.addAttribute("blog", new Blog());
        return "create";
    }


    // This lets you add a post
    @PostMapping("/create")
    public String addPostWithUser(@ModelAttribute Blog blog){
//        code for the setting user is in utils
        User user = Utils.currentUser();
        blog.setUser(user);
        blogDao.save(blog);
//        emailService.prepareAndSend(user, post.getTitle(), post.getBody());
        return "redirect:/blogs/create";
    }


    //    This lets you view your profile
    @GetMapping("/profile")
    public String allPostsBlog(Model model){

        List<Blog> blog = blogDao.findAll();
        model.addAttribute("blog", blog);
        return "/blog_profile";
    }

//     About us page
@GetMapping("/about")
public String aboutUsPage(){
    return "/aboutUs";
}

}