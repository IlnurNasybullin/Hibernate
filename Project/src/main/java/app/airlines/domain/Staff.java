package app.airlines.domain;

import javax.persistence.*;

@Entity
public class Staff extends AbstractPerson {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "staffIdGenerator")
    @SequenceGenerator(name = "staffIdGenerator", sequenceName = "staff_seq", allocationSize = 1)
    private Long id;

    /** Количество часов, проведённых за полётом */
    @Column(name = "flight_hours")
    private Integer flightHours;

    /** Должность сотрудника */
    @Enumerated(EnumType.STRING)
    private StaffPosition position;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFlightHours() {
        return flightHours;
    }

    public void setFlightHours(Integer flightHours) {
        this.flightHours = flightHours;
    }

    public StaffPosition getPosition() {
        return position;
    }

    public void setPosition(StaffPosition position) {
        this.position = position;
    }
}
