package app.airlines.domain;

import app.airlines.domain.dictionary.Country;
import app.airlines.domain.dictionary.PostalIndex;

import javax.persistence.*;

@Entity(name = "address_object")
@Table(uniqueConstraints = @UniqueConstraint(name = "address_object_unique_constraint",
        columnNames = {"country_id", "region", "city", "street", "house", "flat"}))
public class AddressObject extends AbstractEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "addressObjectIdGenerator")
    @SequenceGenerator(name = "addressObjectIdGenerator", sequenceName = "address_object_seq", allocationSize = 1)
    private Long id;

    /** Страна */
    @ManyToOne
    private Country country;

    /** Регион */
    @Column
    private String region;

    /** Город */
    @Column
    private String city;

    /** Улица */
    @Column
    private String street;

    /** Дом */
    @Column
    private String house;

    /** Квартира */
    @Column
    private String flat;

    /** Почтовый индекс */
    @ManyToOne
    @JoinColumn(name = "postal_index_id")
    private PostalIndex postalIndex;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public PostalIndex getPostalIndex() {
        return postalIndex;
    }

    public void setPostalIndex(PostalIndex postalIndex) {
        this.postalIndex = postalIndex;
    }
}
