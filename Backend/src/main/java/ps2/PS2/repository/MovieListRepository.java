package ps2.PS2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ps2.PS2.model.Client;
import ps2.PS2.model.Movie;
import ps2.PS2.model.MovieList;

import java.util.ArrayList;

@Repository
public interface MovieListRepository extends JpaRepository<MovieList,Long> {
    ArrayList<MovieList> findAllByClient(int client);
    void deleteMovieListByClientAndMovie(int client,int movie);
    Boolean existsByClientAndMovie(int client,int movie);
}

