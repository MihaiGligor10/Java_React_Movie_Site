package ps2.PS2.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@EqualsAndHashCode
@IdClass(ClientMovieKey.class)
public class MovieList {

    @Id
   // @ManyToOne(cascade=CascadeType.)
    private int client;
    @Id
    //@ManyToOne(cascade=CascadeType.ALL)
    private int movie;

    @Override
    public String toString() {
        return movie + "\n";
    }
}