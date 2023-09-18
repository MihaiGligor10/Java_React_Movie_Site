package ps2.PS2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ps2.PS2.dto.DelMovieDTO;
import ps2.PS2.dto.MLDTO;
import ps2.PS2.dto.MovieDTO;
import ps2.PS2.model.Client;
import ps2.PS2.model.Movie;
import ps2.PS2.model.MovieList;
import ps2.PS2.repository.MovieListRepository;
import ps2.PS2.repository.MovieRepository;
import ps2.PS2.service.MovieListService;
import ps2.PS2.service.MovieService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class MovieServiceImpl implements MovieService {

    private Movie movie0 = new Movie(0,"0","0","0","0",null);
    private final MovieRepository movieRepository;
    private final MovieListService movieListService;
    private final MovieListRepository movieListRepository;
    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository,MovieListService movieListService,  MovieListRepository movieListRepository) {
        this.movieRepository = movieRepository;
        this.movieListService=movieListService;
        this. movieListRepository= movieListRepository;
    }

    @Override
    public Movie findByName(String name) {
        try{
            System.out.println(movieRepository.findByNumeM(name).toString());
            Movie movie=movieRepository.findByNumeM(name);
            return movie;
        }catch(NullPointerException n){

            System.out.println("nu am gasit film");
            return movie0;
        }
    }
    @Override
    public Boolean doesMovieExist(String nume, String gen) {
        if(movieRepository.findByNumeMAndGen(nume,gen)==null)
        {
            return false;
        }
        else
        {
            return true;
        }

    }
    @Override
    public Movie addMovie(MovieDTO movie) {
        System.out.println(movie);
        if(doesMovieExist(movie.getNumeM() ,movie.getGen()))
        {
            return movie0;
        }else
        {
            Movie m=new Movie(movie.getNumeM(), movie.getGen(),movie.getDescriere(),movie.getImagePath());
            return movieRepository.save(m);
        }
    }




    @Transactional
    @Override
    public void deleteMovie(DelMovieDTO movieDTO) {
       try{
            movieRepository.deleteByNumeMAndGen(movieDTO.getNumeM(), movieDTO.getGen());
        }catch (Exception e)
       {
            System.out.println("Movie might not exist");
       }
    }

    @Override
    public ArrayList<Movie> findAllMoviesByGen(String gen) {
        ArrayList<Movie> m=new ArrayList<>();
        try {
            m.addAll(movieRepository.findAllByGen(gen));
            return m;
        }catch (NullPointerException e){
            m.add(movie0);
            return m;
        }
    }

    @Override
    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie findByid(int id) {
        if(movieRepository.findMovieById(id)==null)
        {
            return null;
        }else
        {
            return movieRepository.findMovieById(id);
        }
    }

    @Override
    public Movie recommendMovie(int client) {
        List<Movie> ml=movieListService.findByClient(client);
        List<String> genuri = new ArrayList<>();
        for(int i = 0 ;i<ml.size();i++)
        {
            genuri.add(ml.get(i).getGen());
        }
        String gen = countFreq(genuri,ml.size());
        List<Movie> allMovies=movieRepository.findAllByGen(gen);
        for(int i = 0 ;i<allMovies.size();i++)
        {
            if(!movieListRepository.existsByClientAndMovie(client,allMovies.get(i).getId()))
            {
                return allMovies.get(i);
            }
        }
        return allMovies.get(0);

    }


    public static String countFreq(List<String> arr, int n)
    {
        boolean visited[] = new boolean[n];

        Arrays.fill(visited, false);
        List<Integer> counter = new ArrayList<>();
        int max=1;
        for (int i = 0; i < n; i++) {

            if (visited[i] == true)
                continue;
            int count = 1;

            for (int j = i + 1; j < n; j++) {
                if (arr.get(i).equals(arr.get(j))) {
                    visited[j] = true;
                    count++;
                }
            }
            if(count>max)
            {
                max=count;
            }
            counter.add(count);
            System.out.println(arr.get(i) + " " + count);
        }
        String ret = null;
        for (int i=0; i < counter.size(); i++) {
           if(counter.get(i)==max) {
            ret=arr.get(i);
           }
        }
        return ret;
    }


}
