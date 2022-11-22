package com.blogspace.models;

import javax.persistence.*;

@Entity
@Table (name = "blogs")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private String body;


}
