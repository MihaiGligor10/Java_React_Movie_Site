package ps2.PS2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ps2.PS2.model.Movie;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {
    Movie findByNumeM(String name);
    ArrayList<Movie> findAllByGen(String gen);

    Movie findMovieById(int id);
    Movie findByNumeMAndGen(String nume , String gen);
    void deleteByNumeMAndGen(String n,String g);



}