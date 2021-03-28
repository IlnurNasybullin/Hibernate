package app.airlines.domain;

import app.airlines.domain.dictionary.PhoneNumber;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@MappedSuperclass
public abstract class AbstractPerson extends AbstractEntity {

    /** Фамилия */
    @Column(nullable = false, length = 50)
    private String lastname;

    /** Имя */
    @Column(nullable = false, length = 25)
    private String firstname;

    /** Отчество */
    @Column(nullable = false, length = 25)
    private String middlename;

    /** Дата рождения */
    @Column
    private LocalDate birthdate;

    /** Документы, удостоверяющие личность (паспорта) */
    @OneToMany
    @JoinTable(inverseJoinColumns = @JoinColumn(name = "document_id"))
    private List<IdentificationDocument> documents;

    /** Адрес */
    @ManyToOne
    private AddressObject address;

    /** Телефонные номера */
    @OneToMany
    @JoinTable(inverseJoinColumns = @JoinColumn(name = "phone_number_id"))
    private List<PhoneNumber> phoneNumbers;

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public AddressObject getAddress() {
        return address;
    }

    public void setAddress(AddressObject address) {
        this.address = address;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public List<IdentificationDocument> getDocuments() {
        return documents;
    }

    public void setDocuments(List<IdentificationDocument> passports) {
        this.documents = passports;
    }
}
