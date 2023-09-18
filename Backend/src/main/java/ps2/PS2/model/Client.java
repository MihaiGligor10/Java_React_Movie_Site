package ps2.PS2.model;


import lombok.*;

import javax.persistence.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@EqualsAndHashCode

public class Client {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String email;
    private String parola;

    public Client(String email, String parola) {
        this.email=email;
        this.parola=parola;
    }

    @OneToMany(mappedBy="client",cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    private List<MovieList> movieLists = new ArrayList<>();

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", parola='" + parola + '\'' +
                '}';
    }
}