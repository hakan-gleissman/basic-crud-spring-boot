package se.sprinto.hakan.basiccrudspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.sprinto.hakan.basiccrudspringboot.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    //färdig att använda för basic CRUD operationer
}
