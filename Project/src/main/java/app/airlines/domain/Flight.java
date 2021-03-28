package app.airlines.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
public class Flight extends AbstractEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flightIdGenerator")
    @SequenceGenerator(name = "flightIdGenerator", sequenceName = "flight_seq", allocationSize = 1)
    private Long id;

    /** Маршрут рейса */
    @ManyToOne(optional = false)
    private Route route;

    /** Запланированное время вылета */
    @Column(nullable = false, name = "start_time")
    private LocalDateTime startTime;

    /** Запланированное время прилёта */
    @Column(nullable = false, name = "end_time")
    private LocalDateTime endTime;

    /** Реальное время вылета */
    @Column(name = "real_start_time", nullable = false)
    private LocalDateTime realStartTime;

    /** Реальное время прилёта */
    @Column(name = "real_end_time", nullable = false)
    private LocalDateTime realEndTime;

    /** Успешность рейса */
    @Column
    private Boolean successful;

    /** Сведения о рейсе */
    @OneToOne
    @JoinColumn(unique = true, name = "flight_passport_id")
    private FlightPassport flightPassport;

    /** Список купленных на рейс билетов */
    @ManyToMany
    @JoinTable(name = "flight_to_plain_ticket", inverseJoinColumns = @JoinColumn(name = "plain_ticket_id"))
    private List<PlainTicket> plainTickets;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public LocalDateTime getRealStartTime() {
        return realStartTime;
    }

    public void setRealStartTime(LocalDateTime realStartTime) {
        this.realStartTime = realStartTime;
    }

    public LocalDateTime getRealEndTime() {
        return realEndTime;
    }

    public void setRealEndTime(LocalDateTime realEndTime) {
        this.realEndTime = realEndTime;
    }

    public Boolean getSuccessful() {
        return successful;
    }

    public void setSuccessful(Boolean successful) {
        this.successful = successful;
    }

    public FlightPassport getFlightPassport() {
        return flightPassport;
    }

    public void setFlightPassport(FlightPassport flightPassport) {
        this.flightPassport = flightPassport;
    }

    public List<PlainTicket> getPlainTickets() {
        return plainTickets;
    }

    public void setPlainTickets(List<PlainTicket> plainTickets) {
        this.plainTickets = plainTickets;
    }
}
