package com.digitalmedia.movies;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.digitalmedia.movies.model.Comment;
import com.digitalmedia.movies.model.Movie;
import com.digitalmedia.movies.repository.MovieRepository;


@SpringBootApplication
@EnableEurekaClient
public class MoviesApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoviesApiApplication.class, args);
    }

    @Bean
	CommandLineRunner runner(MovieRepository movieRepository){
		return args ->{
			
            Comment comment= new Comment("001","Laura", "LF", "Excelente Película!", LocalDateTime.now());
            Comment comment1= new Comment("002","Valentino", "VC", "Un poco dramática, pero buena.", LocalDateTime.now());
			List<Comment>comments= new ArrayList<>();
			comments.add(comment);
			comments.add(comment1);

			Movie movie= new Movie("Gloria", "Edward Zwick","1989", "https://pics.filmaffinity.com/Tiempos_de_gloria-484996182-large.jpg", comments);

			movieRepository.insert(movie);

			Comment comment2= new Comment("003","Agustina", "AC", "Muy buena!", LocalDateTime.now());
            Comment comment3= new Comment("004","Cristian", "CC", "Me gustó mucho.", LocalDateTime.now());
			List<Comment>comments2= new ArrayList<>();
			comments2.add(comment2);
			comments2.add(comment3);

			Movie movie2= new Movie("Ya era hora", "Alessandro Aronadio","2023", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQUTX7dExU9phfI-x_ObH3KZEraK6rC6597tomXFmN7&s", comments2);

			movieRepository.insert(movie2);
		};
    }
}
