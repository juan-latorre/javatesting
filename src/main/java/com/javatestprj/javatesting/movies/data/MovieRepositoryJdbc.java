package com.javatestprj.javatesting.movies.data;

import com.javatestprj.javatesting.movies.model.Genre;
import com.javatestprj.javatesting.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.util.Collection;

public class MovieRepositoryJdbc implements MovieRepository {
    private final JdbcTemplate jdbcTemplate;

    // Inyección de JdbcTemplate a través del constructor
    public MovieRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie findById(long id) {
        Object[] args = {id};
        return jdbcTemplate.queryForObject(
                "SELECT * FROM movies WHERE id = ?",
                movieMapper,
                args
        );
    }

    @Override
    public Collection<Movie> findAll() {
        return jdbcTemplate.query("SELECT * FROM movies", movieMapper);
    }

    @Override
    public void saveOrUpdate(Movie movie) {
        jdbcTemplate.update(
                "INSERT INTO movies (name, minutes, genre) VALUES (?, ?, ?)",
                movie.getName(),
                movie.getMinutes(),
                movie.getGenre().toString()
        );
    }

    private static final RowMapper<Movie> movieMapper = (rs, rowNum) -> new Movie(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getInt("minutes"),
            Genre.valueOf(rs.getString("genre"))
    );


}
