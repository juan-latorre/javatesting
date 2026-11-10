package com.javatestprj.javatesting.movies.service;

import com.javatestprj.javatesting.movies.data.MovieRepository;
import com.javatestprj.javatesting.movies.model.Genre;
import com.javatestprj.javatesting.movies.model.Movie;

import java.util.Collection;
import java.util.stream.Collectors;

public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    /**
     * Retorna únicamente las películas asociadas a un género específico.
     */
    public Collection<Movie> findMoviesByGenre(Genre genre) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getGenre() == genre)
                .collect(Collectors.toList());
    }

    /**
     * Retorna películas cuya duración sea menor o igual al límite indicado.
     */
    public Collection<Movie> findMoviesByLength(int length) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getMinutes() <= length)
                .collect(Collectors.toList());
    }
}
