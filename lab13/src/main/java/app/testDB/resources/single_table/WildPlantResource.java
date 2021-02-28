package app.testDB.resources.single_table;

import app.testDB.domain.single_table.WildPlant;

public final class WildPlantResource extends PlantResource {

    private String species;

    public WildPlantResource() {
        super();
    }

    public WildPlantResource(WildPlant plant) {
        super(plant);
        this.species = plant.getSpecies();
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    @Override
    public String toString() {
        return "WildPlantResource{" + "id=" + id +
                ", name='" + name + '\'' +
                ", species='" + species + '\'' +
                '}';
    }

    @Override
    public WildPlant toEntity() {
        WildPlant wildPlant = new WildPlant();
        wildPlant.setId(id);
        wildPlant.setName(name);
        wildPlant.setSpecies(species);

        return wildPlant;
    }
}
