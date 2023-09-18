package ps2.PS2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ps2.PS2.dto.ActorDTO;
import ps2.PS2.dto.MovieDTO;
import ps2.PS2.service.impl.ActorServiceImpl;

@RestController
public class ActorController {
    private final ActorServiceImpl actorService;

    public ActorController(ActorServiceImpl actorService) {
        this.actorService = actorService;
    }

    @RequestMapping("/addActor")
    @PostMapping
    public ResponseEntity addActor(@RequestBody ActorDTO actorDTO){
        System.out.println(actorDTO + "pentru adaugare actor");
        return ResponseEntity.status(HttpStatus.OK).body(actorService.addActor(actorDTO));
    }

    @RequestMapping("/getAllActors")
    @PostMapping
    public ResponseEntity getAll(){
        System.out.println("get all actors");
        return ResponseEntity.status(HttpStatus.OK).body(actorService.findAllActors());
    }

    @RequestMapping("/getActorById")
    @PostMapping
    public ResponseEntity getActorById(@RequestBody int id){
        System.out.println(id + "get actor by id");
        return ResponseEntity.status(HttpStatus.OK).body(actorService.findById(id));
    }


}
