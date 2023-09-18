package ps2.PS2.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@EqualsAndHashCode
@IdClass(ClientMovieKey.class)
@Table(name = "liker")
public class LikeR {

    @Id
    private int client;
    @Id
    private int movie;

    private boolean liker ;


}
