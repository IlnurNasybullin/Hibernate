package app.airlines.domain;

import app.airlines.domain.dictionary.Airline;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Airplane extends AbstractEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "airplaneIdGenerator")
    @SequenceGenerator(name = "airplaneIdGenerator", sequenceName = "airplane_seq", allocationSize = 1)
    private Long id;

    /** Бортовый номер самолёта */
    @Column(unique = true, nullable = false, name = "registration_number")
    private String registrationNumber;

    /** Название самолёта */
    @Column(nullable = false, length = 30)
    private String name;

    /** Авиакомпания, которой принадлежит самолёт */
    @ManyToOne
    private Airline airline;

    /** Дата выкатки самолёта */
    @Column(name = "rolling_date", nullable = false)
    private LocalDate rollingDate;

    /** Дата первого полёта самолёта */
    @Column(name = "maiden_flight_date", nullable = false)
    private LocalDate maidenFlightDate;

    /** Дата регистрации самолёта */
    @Column(name = "registration_date", nullable = false)
    private LocalDate registrationDate;

    /** Дата ближайшего полёта */
    @Column(name = "nearest_operation_date", nullable = false)
    private LocalDate nearestOperationDate;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airplane) {
        this.airline = airplane;
    }

    public LocalDate getRollingDate() {
        return rollingDate;
    }

    public void setRollingDate(LocalDate rollingDate) {
        this.rollingDate = rollingDate;
    }

    public LocalDate getMaidenFlightDate() {
        return maidenFlightDate;
    }

    public void setMaidenFlightDate(LocalDate maidenFlightDate) {
        this.maidenFlightDate = maidenFlightDate;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public LocalDate getNearestOperationDate() {
        return nearestOperationDate;
    }

    public void setNearestOperationDate(LocalDate nearestOperationDate) {
        this.nearestOperationDate = nearestOperationDate;
    }
}
