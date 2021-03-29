package app.testDB.domain;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
public class Trainer extends AbstractPerson {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trainerIdGenerator")
    @SequenceGenerator(name = "trainerIdGenerator", sequenceName = "trainer_seq", allocationSize = 1)
    private Long id;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
