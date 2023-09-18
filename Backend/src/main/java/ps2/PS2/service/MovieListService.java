package ps2.PS2.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ps2.PS2.dto.MLDTO;
import ps2.PS2.model.Client;
import ps2.PS2.model.Movie;
import ps2.PS2.model.MovieList;

import java.util.ArrayList;
import java.util.List;

@Component
public interface MovieListService {
    MovieList addMovieToList(MLDTO ml);
    void deleteMovieList(MLDTO m);
    List<Movie> findByClient(int client);
    void generateTXT(int client);



}
