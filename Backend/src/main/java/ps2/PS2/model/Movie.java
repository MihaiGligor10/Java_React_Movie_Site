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

public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private int id;
    private String numeM;
    private String gen;
    @Column(length = 65555)
    private String descriere;
    private String imagePath;

    public Movie(String numeM, String gen, String descriere, String imagePath) {
        this.numeM = numeM;
        this.gen = gen;
        this.descriere = descriere;
        this.imagePath = imagePath;
    }

    @OneToMany(mappedBy="movie",cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private List<MovieList> movieLists = new ArrayList<>();

    @OneToMany(mappedBy="movie",cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private List<ActorList> actorLists = new ArrayList<>();

    public Movie(int i, String s, String s1, String s2, String s3, Object o) {
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", numeM='" + numeM + '\'' +
                ", gen='" + gen + '\'' +
                '}';
    }
}
