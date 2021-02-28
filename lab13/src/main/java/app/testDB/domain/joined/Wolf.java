package app.testDB.domain.joined;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Wolf extends Animal {

    @Column
    private Double speed;

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Wolf{" + "id=" + id +
                ", name='" + name + '\'' +
                ", speed=" + speed +
                '}';
    }
}
