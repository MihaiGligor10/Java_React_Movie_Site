package ps2.PS2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ps2.PS2.model.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor,Long> {
    Actor findActorById(int id);
}

