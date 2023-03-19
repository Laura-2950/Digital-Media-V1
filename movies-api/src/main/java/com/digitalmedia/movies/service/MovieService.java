package com.digitalmedia.movies.service;

import com.digitalmedia.movies.model.dto.MovieDto;

import java.util.List;

public interface MovieService {

    MovieDto validateAndGetMovie(String imdbId);

    List<MovieDto> getMovies();

    MovieDto saveMovie(MovieDto movie);

    void deleteMovie(MovieDto movie);
}