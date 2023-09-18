package ps2.PS2.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;

@EqualsAndHashCode
@Getter
public class ActorMovieKey implements Serializable {
    int actor;
    int movie;

    public ActorMovieKey(int actor, int movie) {
        this.actor = actor;
        this.movie = movie;
    }

    public ActorMovieKey() {

    }
}

