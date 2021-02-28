package app.testDB.resources.joined;

import app.testDB.domain.joined.Wolf;

public final class WolfResource extends AnimalResource {

    private Double speed;

    public WolfResource() {
        super();
    }

    public WolfResource(Wolf wolf) {
        super(wolf);
        this.speed = wolf.getSpeed();
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "WolfResource{" + "id=" + id +
                ", name='" + name + '\'' +
                ", speed=" + speed +
                '}';
    }

    @Override
    public Wolf toEntity() {
        Wolf wolf = new Wolf();
        wolf.setId(id);
        wolf.setName(name);
        wolf.setSpeed(speed);

        return wolf;
    }
}
