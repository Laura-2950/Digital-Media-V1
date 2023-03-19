package com.digitalmedia.movies.controller;

import com.digitalmedia.movies.model.dto.CommentDto;
import com.digitalmedia.movies.model.dto.MovieDto;
import com.digitalmedia.movies.service.CommentService;
import com.digitalmedia.movies.service.MovieService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/movies")
public class MoviesController {

    private final MovieService movieService;
    private final CommentService commentService;

    @GetMapping
    @PreAuthorize("hasAuthority('GROUP_admin') OR hasAuthority('GROUP_client')")
    public List<MovieDto> getMovies() {
        return movieService.getMovies();
    }

    @GetMapping("/{imdbId}")
    @PreAuthorize("hasAuthority('GROUP_admin') OR hasAuthority('GROUP_client')")
    public MovieDto getMovie(@PathVariable String imdbId) {
        return movieService.validateAndGetMovie(imdbId);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @PreAuthorize("hasAuthority('GROUP_admin')")
    public MovieDto createMovie(@Valid @RequestBody MovieDto movieDto) {
        return movieService.saveMovie(movieDto);
    }


    @PutMapping("/{imdbId}")
    @PreAuthorize("hasAuthority('GROUP_admin')")
    public MovieDto updateMovie(@PathVariable String imdbId, @Valid @RequestBody MovieDto movieDto) {
        return movieService.saveMovie(movieDto);
    }

    @DeleteMapping("/{imdbId}")
    @PreAuthorize("hasAuthority('GROUP_admin')")
    public MovieDto deleteMovie(@PathVariable String imdbId) {
        MovieDto movie = movieService.validateAndGetMovie(imdbId);
        movieService.deleteMovie(movie);
        return movie;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{imdbId}/comments")
    @PreAuthorize("hasAuthority('GROUP_admin') OR hasAuthority('GROUP_client')")
    public MovieDto addMovieComment(@PathVariable String imdbId, @Valid @RequestBody CommentDto commentDto) {
        MovieDto movie = movieService.validateAndGetMovie(imdbId);
        CommentDto commentDto2= commentService.saveComment(commentDto);
        movie.getComments().add(commentDto2);
        return movieService.saveMovie(movie);
    }
}