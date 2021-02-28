package app.airlines.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "document")
@Table(uniqueConstraints = @UniqueConstraint(name = "identification_document_unique_constraint",
        columnNames = {"series", "number"}))
public class IdentificationDocument extends AbstractEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "identificationDocumentIdGenerator")
    @SequenceGenerator(name = "identificationDocumentIdGenerator", sequenceName = "identification_document_seq",
            allocationSize = 1)
    private Long id;

    /** Серия документа */
    @Column(nullable = false, length = 15)
    private String series;

    /** Номер документа */
    @Column(nullable = false, length = 25)
    private String number;

    /** Кем выдан */
    @Column(nullable = false, length = 125)
    private String issued;

    /** Дата выдачи */
    @Column(name = "issued_date", nullable = false)
    private LocalDate issuedDate;

    /** Срок годности */
    @Column(name = "valid_date")
    private LocalDate validDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getIssued() {
        return issued;
    }

    public void setIssued(String issued) {
        this.issued = issued;
    }

    public LocalDate getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(LocalDate issuedDate) {
        this.issuedDate = issuedDate;
    }

    public LocalDate getValidDate() {
        return validDate;
    }

    public void setValidDate(LocalDate validDate) {
        this.validDate = validDate;
    }
}
