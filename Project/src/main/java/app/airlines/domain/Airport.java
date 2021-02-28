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
    @Column(name = "icao_id", nullable = false, length = 4, unique = true)
    private String icaoId;

    /** Код IATA (International Air Transport Association) */
    @Column(name = "iata_id", nullable = false, length = 3, unique = true)
    private String iataId;

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

    public String getIcaoId() {
        return icaoId;
    }

    public void setIcaoId(String icaoId) {
        this.icaoId = icaoId;
    }

    public String getIataId() {
        return iataId;
    }

    public void setIataId(String iataId) {
        this.iataId = iataId;
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
