package com.blogspace.models;

import javax.persistence.*;

@Entity
@Table(name = "blogs")
public class Blog {

    //Instance Variables

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 100)
    private String body;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    //Getters and Setters
    //Adding a comment to the Blog Class


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // Constructors

    public Blog() {

    }

    public Blog(String title, String body){
        this.title = title;
        this.body = body;
    }

    public Blog(long id, String title, String body){
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Blog(String title, String body, User user) {
        this.title = title;
        this.body = body;
        this.user = user;
    }



}//End of Blog Class