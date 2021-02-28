package app.airlines.domain;

import javax.persistence.*;

@Entity
public class Passenger extends AbstractPerson {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "passengerIdGenerator")
    @SequenceGenerator(name = "passengerIdGenerator", sequenceName = "passenger_seq",
            allocationSize = 1)
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
