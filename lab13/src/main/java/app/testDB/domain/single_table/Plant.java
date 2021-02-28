package app.testDB.domain.single_table;

import app.testDB.domain.AbstractEntry;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Plant extends AbstractEntry {

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
        return "Plant{" + "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
