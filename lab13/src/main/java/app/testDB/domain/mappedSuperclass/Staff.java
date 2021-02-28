package app.testDB.domain.mappedSuperclass;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Staff extends Person {

    @Column
    private String position;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Staff{" + "id=" + id +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
