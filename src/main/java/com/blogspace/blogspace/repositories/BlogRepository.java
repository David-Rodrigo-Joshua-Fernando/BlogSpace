package com.blogspace.blogspace.repositories;

import com.blogspace.blogspace.models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository <Blog, Long> {

}
