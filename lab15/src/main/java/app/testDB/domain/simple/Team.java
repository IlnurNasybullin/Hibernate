package app.testDB.domain.simple;

import app.testDB.domain.AbstractEntity;
import app.testDB.domain.Player;
import app.testDB.domain.Trainer;

import javax.persistence.*;
import java.util.List;

@Entity(name = "simple_team")
public class Team extends AbstractEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "simpleTeamIdGenerator")
    @SequenceGenerator(name = "simpleTeamIdGenerator", sequenceName = "simple_team_seq", allocationSize = 1)
    private Long id;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Column
    private String name;

    @OneToMany
    @JoinTable(inverseJoinColumns = @JoinColumn(name = "player_id"))
    private List<Player> players;

    @OneToOne
    private Trainer trainer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", players=" + players +
                ", trainer=" + trainer +
                '}';
    }
}
