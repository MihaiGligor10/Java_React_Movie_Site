package ps2.PS2.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@EqualsAndHashCode
@Getter

public class ClientMovieKey implements Serializable {
    int client;
    int movie;

    public ClientMovieKey(int client, int movie) {
        this.client = client;
        this.movie = movie;
    }

    public ClientMovieKey() {

    }
}
