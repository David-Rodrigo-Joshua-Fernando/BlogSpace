package com.blogspace.repositories;

import com.blogspace.models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository <Blog, Long> {
    Blog findById(long id);

}
