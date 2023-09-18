package ps2.PS2.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ps2.PS2.dto.DelMovieDTO;
import ps2.PS2.dto.MLDTO;
import ps2.PS2.dto.MovieDTO;
import ps2.PS2.model.Client;
import ps2.PS2.model.Movie;
import ps2.PS2.model.MovieList;

import java.util.ArrayList;
import java.util.List;

@Component
public interface MovieService {
   Movie findByName(String name);
   Movie addMovie(MovieDTO movie);
   Boolean doesMovieExist(String nume,String gen);
   void deleteMovie(DelMovieDTO delMovieDTO);
   List<Movie> findAllMoviesByGen(String gen);
   List<Movie> findAllMovies();
   Movie findByid(int id);
   Movie recommendMovie(int client);
}

