package ps2.PS2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ps2.PS2.dto.DelMovieDTO;
import ps2.PS2.dto.MovieDTO;
import ps2.PS2.service.impl.MovieServiceImpl;

@RestController
public class MovieController {

    private final MovieServiceImpl movieService;

    public MovieController( MovieServiceImpl movieService) {
        this.movieService = movieService;
    }

    @RequestMapping("/addMovie")
    @PostMapping
    public ResponseEntity addMovie(@RequestBody MovieDTO movieDTO){
        System.out.println(movieDTO + "pentru adaugare film");
        return ResponseEntity.status(HttpStatus.OK).body(movieService.addMovie(movieDTO));
    }


    @RequestMapping("/getAllMovies")
    @PostMapping
    public ResponseEntity getAll(){
        System.out.println("get all movies");
        return ResponseEntity.status(HttpStatus.OK).body(movieService.findAllMovies());
    }

    @RequestMapping("/getByIdMovie")
    @PostMapping
    public ResponseEntity getByIdMovie(@RequestBody int id){
        System.out.println(id + "get movie by id");
        return ResponseEntity.status(HttpStatus.OK).body(movieService.findByid(id));
    }

    @RequestMapping("/deleteMovie")
    @PostMapping
    public ResponseEntity deleteMovie(@RequestBody DelMovieDTO mDTO){
        System.out.println(mDTO+"pentru stergere film");
        try
        {
            movieService.deleteMovie(mDTO);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping("/recommendMovie")
    @PostMapping
    public ResponseEntity recommendMovie(@RequestBody int id){
        System.out.println(id + "recomend");
        return ResponseEntity.status(HttpStatus.OK).body(movieService.recommendMovie(id));
    }

}

