package se.sprinto.hakan.basiccrudspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import se.sprinto.hakan.basiccrudspringboot.MovieService;
import se.sprinto.hakan.basiccrudspringboot.model.Movie;

@Controller
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public String getAllMovies(Model model) {
        model.addAttribute("movies", movieService.getAllMovies());
        return "movies";
    }

    @GetMapping("/new")
    public String showCreateForm() {
        return "create-movie";
    }

    @PostMapping
    public String createMovie(@ModelAttribute Movie movie) {
        Movie movie2 = movieService.createMovie(movie);

        return "redirect:/movies";
    }

    @GetMapping("/{id}")
    public String getMovie(@PathVariable Long id, Model model) {
        model.addAttribute("movie", movieService.getMovie(id));
        return "movie";
    }

    @PutMapping("/{id}")
    public String updateMovie(@PathVariable Long id, @ModelAttribute Movie movie) {
        Movie movie2 = movieService.updateMovie(id, movie);
        return "redirect:/movies";
    }

    @GetMapping("/{id}/edit")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Movie movie = movieService.getMovie(id);
        model.addAttribute("movie", movie);
        return "edit-movie";
    }
}
