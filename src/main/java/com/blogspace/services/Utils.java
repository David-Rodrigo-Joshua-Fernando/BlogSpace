package com.blogspace.services;

import com.blogspace.models.User;
import org.springframework.security.core.context.SecurityContextHolder;

public class Utils {

    public static User currentUser(){
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

  public static long currentUserProfile(){
        return ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
    }



}
