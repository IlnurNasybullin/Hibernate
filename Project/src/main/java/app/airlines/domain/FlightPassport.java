package app.airlines.domain;

import app.airlines.domain.dictionary.OperatedCompany;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "flight_passport")
public class FlightPassport extends AbstractEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flightPassportIdGenerator")
    @SequenceGenerator(name = "flightPassportIdGenerator", sequenceName = "flight_passport_seq", allocationSize = 1)
    private Long id;

    /** Строковый идентификатор полётного паспорта */
    @Column(nullable = false, name = "flight_passport_id", unique = true)
    private String flightPassportId;

    /** Самолёт, на котором был осуществлён полёт */
    @ManyToOne
    private Airplane airplane;

    /** Компания, арендовавшая самолёт */
    @ManyToOne
    @JoinColumn(name = "operated_company_id")
    private OperatedCompany operatedCompany;

    /** Персонал, обслуживавший полёт */
    @ManyToMany
    @JoinTable(name = "flight_passport_to_staff", inverseJoinColumns = @JoinColumn(name = "staff_id"))
    private Set<Staff> staffs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlightPassportId() {
        return flightPassportId;
    }

    public void setFlightPassportId(String flightPassportId) {
        this.flightPassportId = flightPassportId;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public OperatedCompany getOperatedCompany() {
        return operatedCompany;
    }

    public void setOperatedCompany(OperatedCompany operatedCompany) {
        this.operatedCompany = operatedCompany;
    }

    public Set<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(Set<Staff> staffs) {
        this.staffs = staffs;
    }
}
