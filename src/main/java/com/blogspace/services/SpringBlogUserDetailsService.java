package com.blogspace.services;


import com.blogspace.models.SpringBlogUserDetails;
import com.blogspace.models.User;
import com.blogspace.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SpringBlogUserDetailsService implements UserDetailsService {

    public final UserRepository usersDao;

    public SpringBlogUserDetailsService(UserRepository usersDao){
        this.usersDao = usersDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = usersDao.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("User details not found for user:" + username);
        } else {
            return new SpringBlogUserDetails(user.getId(),user.getUsername(),user.getEmail(),user.getPassword());
        }
    }
}
