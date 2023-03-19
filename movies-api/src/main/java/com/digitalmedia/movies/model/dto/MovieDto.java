package com.digitalmedia.movies.model.dto;

import lombok.Data;
import java.util.List;

@Data
public class MovieDto {

    private String imdbId;
    private String title;
    private String director;
    private String year;
    private String poster;
    private List<CommentDto> comments;

    public MovieDto(String title, String director, String year, String poster,
    List<CommentDto> comments) {
        this.title= title;
        this.director= director;
        this.year= year;
        this.poster= poster;
        this.comments= comments;
    }

    public MovieDto() {
        //No-args constructor
    }

    public String getImdbId() {
        return imdbId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public List<CommentDto> getComments() {
        return comments;
    }

    public void setComments(List<CommentDto> comments) {
        this.comments = comments;
    }

}