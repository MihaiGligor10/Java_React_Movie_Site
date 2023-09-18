package ps2.PS2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ps2.PS2.dto.MLDTO;
import ps2.PS2.model.Client;
import ps2.PS2.model.Movie;
import ps2.PS2.model.MovieList;
import ps2.PS2.repository.ClientRepository;
import ps2.PS2.repository.MovieListRepository;
import ps2.PS2.repository.MovieRepository;
import ps2.PS2.service.MovieListService;
import ps2.PS2.utils.FileWriterCls;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieListServiceImpl implements MovieListService {

    private final MovieListRepository movieListRepository;
    private final MovieRepository movieRepository;
    private final ClientRepository clientRepository;

    @Autowired
    public MovieListServiceImpl(MovieListRepository movieListRepository, MovieRepository movieRepository,ClientRepository clientRepository) {
        this.movieListRepository = movieListRepository;
        this.movieRepository=movieRepository;
        this.clientRepository= clientRepository;
    }

    @Override
    public MovieList addMovieToList(MLDTO movieList) {
        MovieList m = new MovieList(movieList.getClient(),movieList.getMovie());
        return  movieListRepository.save(m);
    }

    @Transactional
    @Override
    public void deleteMovieList(MLDTO mldto) {
        try {
            movieListRepository.deleteMovieListByClientAndMovie(mldto.getClient(),mldto.getMovie());
        }catch(Exception e)
        {
            System.out.println("acest element din lista nu exista");
        }


    }

    @Override
    public List<Movie> findByClient(int client) {
        if(movieListRepository.findAllByClient(client)==null)
        {
            return null;
        }
        else
        {
            List<MovieList> ml=movieListRepository.findAllByClient(client);
            List<Movie> m = new ArrayList<>();
            for(int i = 0 ;i<ml.size();i++)
            {
                m.add(movieRepository.findMovieById(ml.get(i).getMovie()));
            }
            return m;
        }
    }

    @Override
    public void generateTXT(int client) {
        List<Movie> m= findByClient(client);
        FileWriterCls f= FileWriterCls.getInstance();
        f.generateTXT(clientRepository.findById(client).getEmail(),m);
    }

}
