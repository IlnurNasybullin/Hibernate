package app.airlines.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "plain_ticket")
public class PlainTicket {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "plainTicketIdGenerator")
    @SequenceGenerator(name = "plainTicketIdGenerator", sequenceName = "plain_ticket_seq", allocationSize = 1)
    private Long id;

    /** Строковый идентификационный номер билета */
    @Column(name = "ticket_id", unique = true, nullable = false)
    private String ticketId;

    /** Тип билета */
    @Enumerated(EnumType.STRING)
    private TicketType type;

    /** Цена билета */
    @Column
    private Double price;

    /** Номер места в самолёте */
    @Column
    private String place;

    @ManyToOne
    @JoinColumn
    private Passenger passenger;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public TicketType getType() {
        return type;
    }

    public void setType(TicketType type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlainTicket that = (PlainTicket) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
