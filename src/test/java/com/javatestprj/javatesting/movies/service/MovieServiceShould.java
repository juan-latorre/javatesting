package com.javatestprj.javatesting.movies.service;

import com.javatestprj.javatesting.movies.data.MovieRepository;
import com.javatestprj.javatesting.movies.model.Genre;
import com.javatestprj.javatesting.movies.model.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class MovieServiceShould {

    private MovieRepository movieRepository;
    private MovieService movieService;

    @BeforeEach
    void setUp() {
        movieRepository = Mockito.mock(MovieRepository.class);
        movieService = new MovieService(movieRepository);

        // Simulamos el conjunto de datos retornado por findAll()
        when(movieRepository.findAll()).thenReturn(Arrays.asList(
                new Movie(1, "Memento", 113, Genre.THRILLER),
                new Movie(2, "Matrix", 136, Genre.ACTION),
                new Movie(3, "Super 8", 112, Genre.THRILLER),
                new Movie(4, "Home Alone", 103, Genre.COMEDY),
                new Movie(5, "The Hangover", 100, Genre.COMEDY),
                new Movie(6, "Schindler's List", 195, Genre.DRAMA)
        ));
    }

    @Test
    void return_movies_by_genre() {
        Collection<Movie> movies = movieService.findMoviesByGenre(Genre.COMEDY);

        List<Integer> movieIds = getMovieIds(movies);

        assertEquals(Arrays.asList(4, 5), movieIds,
                "Debe retornar exactamente las películas que pertenecen al género Comedia");
    }

    @Test
    void return_movies_by_duration() {
        // Películas con duración menor o igual a 119 minutos
        Collection<Movie> movies = movieService.findMoviesByLength(119);

        List<Integer> movieIds = getMovieIds(movies);

        assertEquals(Arrays.asList(1, 3, 4, 5), movieIds,
                "Debe retornar películas con duración menor o igual a 119 minutos");
    }

    private List<Integer> getMovieIds(Collection<Movie> movies) {
        return movies.stream()
                .map(Movie::getId)
                .collect(Collectors.toList());
    }

}