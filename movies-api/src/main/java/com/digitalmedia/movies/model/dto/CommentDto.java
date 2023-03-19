package com.digitalmedia.movies.model.dto;

import java.time.LocalDateTime;

public class CommentDto {
    private String imdbId;
    private String username;
    private String avatar;
    private String text;
    private LocalDateTime timestamp;


    public CommentDto(String username, String avatar, String text, LocalDateTime timestamp) {
        this.username= username;
        this.avatar= avatar;
        this.text= text;
        this.timestamp= timestamp;
    }

    public CommentDto() {
        //No-args constructor
    }

    public String getImdbId() {
        return imdbId;
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
