package ps2.PS2.service;

import org.springframework.stereotype.Component;
import ps2.PS2.dto.ActorDTO;
import ps2.PS2.model.Actor;
import ps2.PS2.model.Movie;

import java.util.List;

@Component
public interface ActorService {
    Actor addActor(ActorDTO actorDto);
    List<Actor> findAllActors();
    Actor findById(int id);
}
