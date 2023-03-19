package com.digitalmedia.movies.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "movies")
public class Movie {

    @Id
    private String imdbId;
    private String title;
    private String director;
    private String year;
    private String poster;
    private List<Comment> comments = new ArrayList<>();

    public Movie(String imdbId, String title, String director, String year, String poster,
            List<Comment> comments) {
                this.imdbId= imdbId;
                this.title= title;
                this.director= director;
                this.year= year;
                this.poster= poster;
                this.comments= comments;
    }

    public Movie(String title, String director, String year, String poster, List<Comment> comments) {
        this.title= title;
        this.director= director;
        this.year= year;
        this.poster= poster;
        this.comments= comments;
    }

    public Movie() {
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }


}