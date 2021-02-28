package app.testDB.resources.table_per_class;

import app.testDB.domain.table_per_class.Unit;
import app.testDB.resources.AbstractResource;

public class UnitResource extends AbstractResource<Unit> {

    protected String name;
    protected Double health;

    public UnitResource() {
        super();
    }

    public UnitResource(Unit unit) {
        super(unit);
        this.name = unit.getName();
        this.health = unit.getHealth();
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
    public Unit toEntity() {
        Unit unit = new Unit();
        unit.setId(id);
        unit.setName(name);
        unit.setHealth(health);

        return unit;
    }

    @Override
    public String toString() {
        return "UnitResource{" + "id=" + id +
                ", name='" + name + '\'' +
                ", health=" + health +
                '}';
    }
}
