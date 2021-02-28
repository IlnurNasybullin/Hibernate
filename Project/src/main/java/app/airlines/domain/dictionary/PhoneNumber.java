package app.airlines.domain.dictionary;

import app.airlines.domain.AbstractEntity;
import app.airlines.domain.BiDictionary;

import javax.persistence.*;

@Entity(name = "dict_phone_number")
public class PhoneNumber extends AbstractEntity implements BiDictionary {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "phoneNumberIdGenerator")
    @SequenceGenerator(name = "phoneNumberIdGenerator", sequenceName = "phone_number_seq", allocationSize = 1)
    private Long id;

    @Column(name = "phone_number", unique = true, nullable = false)
    private String phoneNumber;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return phoneNumber;
    }

    @Override
    public void setName(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return getName();
    }

    public void setPhoneNumber(String phoneNumber) {
        setName(phoneNumber);
    }
}
