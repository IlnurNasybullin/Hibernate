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
    @JoinColumn(name = "from")
    private Airport from;

    /** Аэропорт прибытия */
    @ManyToOne
    @JoinColumn(name = "to")
    private Airport to;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Airport getFrom() {
        return from;
    }

    public void setFrom(Airport from) {
        this.from = from;
    }

    public Airport getTo() {
        return to;
    }

    public void setTo(Airport to) {
        this.to = to;
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
