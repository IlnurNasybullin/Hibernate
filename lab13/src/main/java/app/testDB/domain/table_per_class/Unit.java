package app.testDB.domain.table_per_class;

import app.testDB.domain.AbstractEntry;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Unit extends AbstractEntry {

    @Id
    @Column
    protected Long id;

    @Column
    protected String name;

    @Column
    protected Double health;

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

    public Double getHealth() {
        return health;
    }

    public void setHealth(Double health) {
        this.health = health;
    }

    @Override
    public String toString() {
        return "Unit{" + "id=" + id +
                ", name='" + name + '\'' +
                ", health=" + health +
                '}';
    }
}
