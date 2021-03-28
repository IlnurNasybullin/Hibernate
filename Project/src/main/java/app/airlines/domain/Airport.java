package app.airlines.domain;

import javax.persistence.*;

@Entity
public class Airport extends AbstractEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "airportIdGenerator")
    @SequenceGenerator(name = "airportIdGenerator", sequenceName = "airport_seq", allocationSize = 1)
    private Long id;

    /** Код ICAO (International Civil Aviation Organization) */
    @Column(nullable = false, length = 4, unique = true)
    private String icao;

    /** Код IATA (International Air Transport Association) */
    @Column(nullable = false, length = 3, unique = true)
    private String iata;

    /** Координата широты */
    @Column
    private Double latitude;

    /** Координата долготы */
    @Column
    private Double longitude;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIcao() {
        return icao;
    }

    public void setIcao(String icao) {
        this.icao = icao;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
