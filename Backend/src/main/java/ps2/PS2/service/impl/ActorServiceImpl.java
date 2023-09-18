package ps2.PS2.service.impl;

import org.springframework.stereotype.Service;
import ps2.PS2.dto.ActorDTO;
import ps2.PS2.model.Actor;
import ps2.PS2.model.Movie;
import ps2.PS2.repository.ActorRepository;
import ps2.PS2.service.ActorService;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    private final ActorRepository actorRepository ;

    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public Actor addActor(ActorDTO actorDto) {
        Actor actor= new Actor(actorDto.getNume(),actorDto.getVarsta(),actorDto.getIstoric(),actorDto.getImagePath());
        return actorRepository.save(actor);
    }

    @Override
    public List<Actor> findAllActors() {
        return actorRepository.findAll();
    }



    @Override
    public Actor findById(int id) {
        if(actorRepository.findActorById(id)==null)
        {
            return null;
        }else
        {
            return actorRepository.findActorById(id);
        }
    }
}
