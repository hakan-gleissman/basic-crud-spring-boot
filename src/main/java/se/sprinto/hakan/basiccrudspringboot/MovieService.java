package se.sprinto.hakan.basiccrudspringboot;

import org.springframework.stereotype.Service;
import se.sprinto.hakan.basiccrudspringboot.model.Movie;
import se.sprinto.hakan.basiccrudspringboot.repository.MovieRepository;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }
}
