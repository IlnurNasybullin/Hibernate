package app.testDB.domain.single_table;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "wild_plant")
public class WildPlant extends Plant {

    @Column
    private String species;

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    @Override
    public String toString() {
        return "WildPlant{" + "id=" + id +
                ", name='" + name + '\'' +
                ", species='" + species + '\'' +
                '}';
    }
}
