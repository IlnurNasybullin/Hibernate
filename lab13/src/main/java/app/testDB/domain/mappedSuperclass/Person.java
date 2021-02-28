package app.testDB.domain.mappedSuperclass;

import app.testDB.domain.AbstractEntry;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Person extends AbstractEntry {

    @Id
    @Column
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
        return "Person{" + "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
