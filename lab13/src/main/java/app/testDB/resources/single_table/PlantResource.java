package app.testDB.resources.single_table;

import app.testDB.domain.single_table.Plant;
import app.testDB.resources.AbstractResource;

public class PlantResource extends AbstractResource<Plant> {

    protected String name;

    public PlantResource() {
        super();
    }

    public PlantResource(Plant plant) {
        super(plant);
        this.name = plant.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Plant toEntity() {
        Plant plant = new Plant();
        plant.setId(id);
        plant.setName(name);

        return plant;
    }

    @Override
    public String toString() {
        return "PlantResource{" + "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
