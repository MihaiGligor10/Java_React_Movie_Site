package ps2.PS2.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@EqualsAndHashCode
@IdClass(ActorMovieKey.class)
public class ActorList {
    @Id
    private int actor;
    @Id
    private int movie;
}
