package app.airlines.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "unique_route_constraint", columnNames = {"from", "to"}))
public class Route {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "routeIdGenerator")
    @SequenceGenerator(name = "routeIdGenerator", sequenceName = "route_seq", allocationSize = 1)
    private Long id;

    /** Аэропорт отбытия */
    @ManyToOne
    @JoinColumn(name = "from_airport_id")
    private Airport fromAirport;

    /** Аэропорт прибытия */
    @ManyToOne
    @JoinColumn(name = "to_airport_id")
    private Airport toAirport;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Airport getFromAirport() {
        return fromAirport;
    }

    public void setFromAirport(Airport fromAirport) {
        this.fromAirport = fromAirport;
    }

    public Airport getToAirport() {
        return toAirport;
    }

    public void setToAirport(Airport toAirport) {
        this.toAirport = toAirport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return Objects.equals(id, route.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
