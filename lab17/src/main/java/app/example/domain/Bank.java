package app.example.domain;

import javax.persistence.*;

@Entity
public class Bank {

    @Id
    @Column(name = "pk_bank")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bank")
    @SequenceGenerator(name = "bank", sequenceName = "bank_seq", allocationSize=1)
    private Long id;

    private String name;

    private String test;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}

