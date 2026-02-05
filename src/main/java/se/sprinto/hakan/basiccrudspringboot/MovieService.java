package se.sprinto.hakan.basiccrudspringboot;

import org.springframework.stereotype.Service;
import se.sprinto.hakan.basiccrudspringboot.model.Movie;
import se.sprinto.hakan.basiccrudspringboot.repository.MovieRepository;

import java.util.List;
import java.util.NoSuchElementException;

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

    public Movie getMovie(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No movie found with id: " + id));
    }

    public Movie updateMovie(Long id, Movie movie) {
        movie.setId(id);
        return movieRepository.save(movie);
    }


}
