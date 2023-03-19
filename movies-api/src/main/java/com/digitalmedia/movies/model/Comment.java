package com.digitalmedia.movies.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "comments")
public class Comment {

    @Id
    private String imdbId;
    private String username;
    private String avatar;
    private String text;
    private LocalDateTime timestamp;

    public Comment(String imdbId, String username, String avatar, String text, LocalDateTime timestamp) {
        this.imdbId= imdbId;
        this.username= username;
        this.avatar= avatar;
        this.text= text;
        this.timestamp= timestamp;
    }

    public Comment(String username, String avatar, String text, LocalDateTime timestamp) {
        this.username= username;
        this.avatar= avatar;
        this.text= text;
        this.timestamp= timestamp;
    }

    public Comment() {
        //No-args constructor
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
}
