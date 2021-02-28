package app.testDB.domain.joined;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Cat extends Animal {

    @Column
    private Byte kids;

    public Byte getKids() {
        return kids;
    }

    public void setKids(Byte kids) {
        this.kids = kids;
    }

    @Override
    public String toString() {
        return "Cat{" + "id=" + id +
                ", name='" + name + '\'' +
                ", kids=" + kids +
                '}';
    }
}
