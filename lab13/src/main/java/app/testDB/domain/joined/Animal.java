package app.testDB.domain.joined;

import app.testDB.domain.AbstractEntry;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Animal extends AbstractEntry {

    @Id
    protected Long id;

    @Column
    protected String name;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal{" + "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
