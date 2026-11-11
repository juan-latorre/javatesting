package com.javatestprj.javatesting.movies.data;

import com.javatestprj.javatesting.movies.model.Genre;
import com.javatestprj.javatesting.movies.model.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class MovieRepositoryIntegrationTest {
    private MovieRepositoryJdbc movieRepository;

    @BeforeEach
    void setUp() {
        // Datos de conexión al contenedor Docker de MySQL
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/movies?useSSL=false&serverTimezone=UTC");
        dataSource.setUsername("platzi");
        dataSource.setPassword("platzi");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        movieRepository = new MovieRepositoryJdbc(jdbcTemplate);
    }

    @Test
    void load_all_movies() {
        Collection<Movie> movies = movieRepository.findAll();

        assertEquals(
                Arrays.asList(
                        new Movie(1, "Memento", 113, Genre.THRILLER),
                        new Movie(2, "Matrix", 136, Genre.ACTION),
                        new Movie(3, "Super 8", 112, Genre.THRILLER),
                        new Movie(4, "Home Alone", 103, Genre.COMEDY),
                        new Movie(5, "The Hangover", 100, Genre.COMEDY),
                        new Movie(6, "Schindler's List", 195, Genre.DRAMA)
                ),
                movies,
                "Debe recuperar las 6 películas registradas en la base de datos MySQL"
        );
    }

    @Test
    void load_movie_by_id() {
        Movie movie = movieRepository.findById(2);

        assertEquals(new Movie(2, "Matrix", 136, Genre.ACTION), movie);
    }
}