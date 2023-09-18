package ps2.PS2.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@EqualsAndHashCode
public class Actor {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nume;
    private int varsta;
    @Column(length = 65555)
    private String istoric;
    private String imagePath;

    @OneToMany(mappedBy="actor",cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    private List<ActorList> actorLists = new ArrayList<>();

    public Actor(String nume, int varsta, String istoric, String imagePath) {
        this.nume = nume;
        this.varsta = varsta;
        this.istoric = istoric;
        this.imagePath = imagePath;
    }
}
