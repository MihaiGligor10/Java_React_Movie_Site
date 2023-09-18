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
public class Review {


    @Id
    private int client;
    @Id
    private int movie;
    @Column(length = 65555)
    private String review;


}
