package se.sprinto.hakan.basiccrudspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
