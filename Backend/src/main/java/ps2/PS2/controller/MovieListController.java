package ps2.PS2.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ps2.PS2.dto.MLDTO;
import ps2.PS2.service.MovieListService;

//@CrossOrigin
@RestController
public class MovieListController {

    private final MovieListService movieListService;

    public MovieListController(MovieListService movieListService) {
        this.movieListService = movieListService;
    }

    @RequestMapping("/addML")
    @PostMapping
    public ResponseEntity addML(@RequestBody MLDTO ml){
        System.out.println(ml + "pentru add to ml");
        return ResponseEntity.status(HttpStatus.OK).body(movieListService.addMovieToList(ml));

    }

    @RequestMapping("/getMoviesByClient")
    @PostMapping
    public ResponseEntity getMoviesByClient(@RequestBody int client){
        System.out.println(client + "pentru add to ml");
        return ResponseEntity.status(HttpStatus.OK).body(movieListService.findByClient(client));

    }

    @RequestMapping("/deleteMovieList")
    @PostMapping
    public ResponseEntity deleteMovie(@RequestBody MLDTO mDTO){
        System.out.println(mDTO+"pentru stergere film");
        try
        {
            movieListService.deleteMovieList(mDTO);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


    @RequestMapping("/generateTXT")
    @PostMapping
    public ResponseEntity generateTXT(@RequestBody int client){
        System.out.println(client+"pentru generare txt");
        try
        {
            movieListService.generateTXT(client);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }



}
