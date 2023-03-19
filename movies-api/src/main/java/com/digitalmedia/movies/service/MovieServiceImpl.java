package com.digitalmedia.movies.service;

import com.digitalmedia.movies.exception.MovieNotFoundException;
import com.digitalmedia.movies.model.Movie;
import com.digitalmedia.movies.model.dto.MovieDto;
import com.digitalmedia.movies.repository.MovieRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final ObjectMapper mapper;


    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository, ObjectMapper mapper) {
        this.movieRepository = movieRepository;
        this.mapper=mapper;
    }

    @Override
    public MovieDto validateAndGetMovie(String imdbId) throws MovieNotFoundException{
        Optional<Movie>movie= movieRepository.findById(imdbId);
        MovieDto movieDto= new MovieDto();
        if (movie.isPresent()) {
            movieDto= mapper.convertValue(movie, MovieDto.class);   
        }else{
            new MovieNotFoundException(imdbId);
        }
        return movieDto;
    }

    @Override
    public List<MovieDto> getMovies() {
        List<Movie> movies= movieRepository.findAll();
        List<MovieDto>movieDtos= new ArrayList<>();
        for (Movie movie : movies) {
            movieDtos.add(mapper.convertValue(movie, MovieDto.class));
        }
        return movieDtos;
    }

    @Override
    public MovieDto saveMovie(MovieDto movie) {
        Movie movie2= movieRepository.save(mapper.convertValue(movie, Movie.class));
        MovieDto movieDto= null;
        if (!movie2.getTitle().isBlank()) {
            movieDto= mapper.convertValue(movie2, MovieDto.class);
        }
        return movieDto;
    }

    @Override
    public void deleteMovie(MovieDto movie) {
        movieRepository.delete(mapper.convertValue(movie, Movie.class));
    }
}