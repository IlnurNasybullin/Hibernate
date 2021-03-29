package app.testDB.domain.cascade;

import app.testDB.domain.AbstractEntity;
import app.testDB.domain.Player;
import app.testDB.domain.Trainer;

import javax.persistence.*;
import java.util.List;

@Entity(name = "cascade_team")
public class Team extends AbstractEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cascadeTeamIdGenerator")
    @SequenceGenerator(name = "cascadeTeamIdGenerator", sequenceName = "cascade_team_seq", allocationSize = 1)
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

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinTable(inverseJoinColumns = @JoinColumn(name = "player_id"))
    private List<Player> players;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
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
}
