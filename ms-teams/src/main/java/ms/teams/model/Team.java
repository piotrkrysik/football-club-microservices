package ms.teams.model;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Data
@Entity
public class Team implements Serializable {

    @ElementCollection
    @CollectionTable(name = "PLAYER_TEAM",
            joinColumns = @JoinColumn(name = "team_id")
    )
    @Column(name = "player_id")
    public Set<Integer> players;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String logo;

    @Transient
    private List<String> playerNames = new ArrayList<>();

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", logo='" + logo + '\'' +
                '}';
    }
}